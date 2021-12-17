//package com.yangt.hirac.core.event.handler;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yangt.hirac.common.constants.Constants;
//import com.yangt.hirac.common.constants.LogConstant;
//import com.yangt.hirac.common.entity.*;
//import com.yangt.hirac.common.entity.model.JobGroupCache;
//import com.yangt.hirac.common.entity.vo.HeraActionVo;
//import com.yangt.hirac.common.entity.vo.HeraJobHistoryVo;
//import com.yangt.hirac.common.enums.JobScheduleTypeEnum;
//import com.yangt.hirac.common.enums.StatusEnum;
//import com.yangt.hirac.common.enums.TriggerTypeEnum;
//import com.yangt.hirac.common.logs.ErrorLog;
//import com.yangt.hirac.common.logs.ScheduleLog;
//import com.yangt.hirac.common.service.*;
//import com.yangt.hirac.common.util.ActionUtil;
//import com.yangt.hirac.common.util.BeanConvertUtils;
//import com.yangt.hirac.common.vo.JobStatus;
//import com.yangt.hirac.core.enums.AlarmStatusEnum;
//import com.yangt.hirac.core.event.*;
//import com.yangt.hirac.core.event.base.ApplicationEvent;
//import com.yangt.hirac.core.event.base.Events;
//import com.yangt.hirac.core.job.CancelHadoopJob;
//import com.yangt.hirac.core.job.JobContext;
//import com.yangt.hirac.core.netty.master.Master;
//import com.yangt.hirac.core.netty.master.MasterContext;
//import com.yangt.hirac.core.quartz.HeraQuartzJob;
//import com.yangt.hirac.core.util.AlarmUtils;
//import com.yangt.hirac.core.util.EmailModelUtils;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.quartz.*;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import static com.yangt.hirac.common.enums.JobScheduleTypeEnum.Independent;
//import static com.yangt.hirac.common.enums.StatusEnum.RUNNING;
//
///**
// * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
// * @time: Created in 下午5:24 2018/4/19
// * @desc 每种任务执行状态都对应相应事件，job执行生命周期事件执行逻辑
// */
//@Slf4j
//@Builder
//@AllArgsConstructor
//public class JobHandler extends AbstractHandler {
//
//    @Getter
//    private final String actionId;
//    private JobGroupCache cache;
//    private HeraJobHistoryService jobHistoryService;
//    private HeraGroupService heraGroupService;
//    private HeraJobActionService heraJobActionService;
//    private HeraJobService heraJobService;
//    private HiracDutyService hiracDutyService;
//    private Master master;
//    private MasterContext masterContext;
//    private HeraUserService heraUserService;
//    private final static String VOICE_PARAM = "FAULT_CODE:1,APP:任务%s,ERR_MSG:任务执行失败";
//    private final static String RERUN_STATUS = "re-running";
//
//    public JobHandler(String actionId, Master master, MasterContext masterContext) {
//        this.actionId = actionId;
//        this.jobHistoryService = masterContext.getHeraJobHistoryService();
//        this.heraGroupService = masterContext.getHeraGroupService();
//        this.heraJobActionService = masterContext.getHeraJobActionService();
//        this.heraUserService = masterContext.getHeraUserService();
//        this.heraJobService = masterContext.getHeraJobService();
//        this.hiracDutyService = masterContext.getHiracDutyService();
//        this.cache = JobGroupCache.builder().actionId(actionId).heraJobActionService(heraJobActionService).build();
//        this.master = master;
//        this.masterContext = masterContext;
//        registerEventType(Events.Initialize);
//    }
//
//    @Override
//    public boolean canHandle(ApplicationEvent event) {
//        if (super.canHandle(event)) {
//            return true;
//        }
//        return event instanceof HeraJobFailedEvent || event instanceof HeraJobSuccessEvent ||
//                event instanceof HeraJobLostEvent || event instanceof HeraScheduleTriggerEvent ||
//                event instanceof HeraJobMaintenanceEvent;
//    }
//
//    /**
//     * 接受到任务事件广播处理逻辑
//     *
//     * @param event
//     */
//    @Override
//    public void handleEvent(ApplicationEvent event) {
//        if (event.getType() == Events.Initialize) {
//            handleInitialEvent();
//            return;
//        }
//        if (event instanceof HeraJobSuccessEvent) {
//            handleSuccessEvent((HeraJobSuccessEvent) event);
//        } else if (event instanceof HeraJobFailedEvent) {
//            handleFailedEvent((HeraJobFailedEvent) event);
//        } else if (event instanceof HeraScheduleTriggerEvent) {
//            handleTriggerEvent((HeraScheduleTriggerEvent) event);
//        } else if (event instanceof HeraJobMaintenanceEvent) {
//            handleMaintenanceEvent((HeraJobMaintenanceEvent) event);
//        } else if (event instanceof HeraJobLostEvent) {
//            handleLostEvent((HeraJobLostEvent) event);
//        }
//    }
//
//    /**
//     * 1.running 任务重试
//     * 2.调度任务加入调度池
//     */
//    public void handleInitialEvent() {
//
//        HeraAction heraAction = heraJobActionService.findById(actionId);
//        if (heraAction != null) {
//            //对版本表中处于running状态的任务进行重试
//            if (RUNNING.toString().equals(heraAction.getStatus())) {
//                ErrorLog.error("actionId = " + actionId + " 处于RUNNING状态，说明该job状态丢失，立即进行重试操作。。。");
//                //有历史版本
//                if (heraAction.getHistoryId() != null) {
//                    HeraJobHistory jobHistory = jobHistoryService.findById(heraAction.getHistoryId());
//                    if (jobHistory == null) {
//                        return;
//                    }
//                    HeraJobHistoryVo heraJobHistory = BeanConvertUtils.convert(jobHistory);
//                    // 搜索上一次运行的日志，从日志中提取jobId 进行kill
//                    if (jobHistory.getStatus() == null || !jobHistory.getStatus().equals(StatusEnum.SUCCESS.toString())) {
//                        try {
//                            JobContext tmp = JobContext.getTempJobContext(JobContext.MANUAL_RUN);
//                            heraJobHistory.setIllustrate(LogConstant.SERVER_START_JOB_LOG);
//                            tmp.setHeraJobHistory(heraJobHistory);
//                            new CancelHadoopJob(tmp).run();
//                            master.run(heraJobHistory);
//                        } catch (Exception e) {
//                            log.error("handleInitialEvent", e);
//                        }
//                    }
//                } else {
//                    HeraJobHistory heraJobHistory = HeraJobHistory.builder()
//                            .jobId(heraAction.getJobId())
//                            .actionId(heraAction.getId().toString())
//                            .triggerType(TriggerTypeEnum.MANUAL_RECOVER.getId())
//                            .illustrate(LogConstant.SERVER_START_JOB_LOG)
//                            .log(LogConstant.SERVER_START_JOB_LOG)
//                            .operator(heraAction.getOwner())
//                            .hostGroupId(heraAction.getHostGroupId())
//                            .isNrt(heraAction.getIsNrt())
//                            .build();
//                    masterContext.getHeraJobHistoryService().insert(heraJobHistory);
//                    master.run(BeanConvertUtils.convert(heraJobHistory));
//                }
//            }
//        }
//
//        /**
//         * 如果是定时任务，启动定时程序,独立调度任务，创建quartz调度
//         *
//         */
//        HeraActionVo heraActionVo = cache.getHeraActionVo();
//        boolean isSchedule = heraActionVo.getAuto() && Objects.equals(heraActionVo.getScheduleType(), Independent);
//        if (isSchedule) {
//            try {
//                createScheduleJob(masterContext.getDispatcher(), heraActionVo);
//                ScheduleLog.info("create job quartz success,actionId={}",heraActionVo.getId());
//            } catch (Exception e) {
//                if (e instanceof SchedulerException) {
//                    heraActionVo.setAuto(false);
//                    ErrorLog.error("create job quartz schedule error");
//                }
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//
//    /**
//     * 收到广播的任务成功事件的处理流程，每次自动调度任务成功执行，会进行一次全局的SuccessEvent广播，使得依赖任务可以更新readyDependent
//     *
//     * @param event
//     */
//    private void handleSuccessEvent(HeraJobSuccessEvent event) {
//        if (event.getTriggerType() == TriggerTypeEnum.MANUAL) {
//            return;
//        }
//        String jobId = event.getJobId();
//        if(event.getTriggerType() == TriggerTypeEnum.MANUAL_RERUN) {
//            cache.refresh();
//        }
//        HeraActionVo heraActionVo = cache.getHeraActionVo();
//        String cronExpression = heraActionVo.getCronExpression();
//        if (heraActionVo == null) {
//            autoRecovery();
//            return;
//        }
//        if (!heraActionVo.getAuto()) {
//            return;
//        }
//        if (heraActionVo.getScheduleType() == Independent) {
//            return;
//        }
//        if (heraActionVo.getDependencies() == null || !heraActionVo.getDependencies().contains(jobId)) {
//            return;
//        }
//        if (event.getTriggerType() == TriggerTypeEnum.MANUAL_RERUN && !RERUN_STATUS.equals(heraActionVo.getStatus())) {
//            return;
//        }
//        JobStatus jobStatus;
//        //必须同步
//        synchronized (this) {
//            jobStatus = heraJobActionService.findJobStatus(actionId);
//            ScheduleLog.info(actionId + " received a success dependency job with actionId = " + jobId);
//            jobStatus.getReadyDependency().put(jobId, String.valueOf(System.currentTimeMillis()));
//            heraJobActionService.updateStatus(jobStatus);
//        }
//        boolean allComplete = true;
//        for (String key : heraActionVo.getDependencies()) {
//            if (jobStatus.getReadyDependency().get(key) == null) {
//                allComplete = false;
//                break;
//            }
//        }
//        if (allComplete) {
//            if(isOvertime(cronExpression)) {
//                ScheduleLog.info("JobId: " + jobStatus.getActionId() + " all dependency jobs is ready and scheduler is overtime,run!");
//                startNewJob(event.getTriggerType(), heraActionVo);
//            } else {
//                try {
//                    createScheduleJob(masterContext.getDispatcher(), heraActionVo);
//                } catch (Exception e) {
//                    if (e instanceof SchedulerException) {
//                        ErrorLog.error("create job quartz schedule error");
//                    }
//                    throw new RuntimeException(e);
//                }
//                ScheduleLog.info(actionId + " scheduler is in future, wait for running!" + JSONObject.toJSONString(jobStatus.getReadyDependency().keySet()));
//            }
//        } else {
//            ScheduleLog.info(actionId + " some of dependency is not ready, waiting" + JSONObject.toJSONString(jobStatus.getReadyDependency().keySet()));
//        }
//    }
//
//
//    /**
//     * 判断任务的调度是否过时，如果只差1分钟，容错处理也会判断为过时
//     * 防止生成了无效的定时任务
//     * @param cronExpression crontab表达式
//     * @return
//     */
//    private static Boolean isOvertime(String cronExpression) {
//        String[] crontab = cronExpression.trim().split("\\s");
//        int minute = Integer.parseInt(crontab[1]);
//        int hour = Integer.parseInt(crontab[2]);
//        int day = Integer.parseInt(crontab[3]);
//        LocalDateTime now = LocalDateTime.now();
//        int actrueMinute = now.getMinute();
//        int actrueHour = now.getHour();
//        int actrueDay = now.getDayOfMonth();
//        if(actrueDay == day) {
//            if(actrueHour > hour) {
//                return true;
//            }
//            if(actrueHour == hour) {
//                if(actrueMinute >= minute) {
//                    return true;
//                }
//                return minute - actrueMinute == 1;
//            } else {
//                return false;
//            }
//        }
//
//        return false;
//    }
//
//    private void startNewJob(TriggerTypeEnum triggerType, HeraActionVo heraActionVo) {
//        HeraJobHistory history = HeraJobHistory.builder().
//                actionId(heraActionVo.getId()).
//                illustrate(LogConstant.DEPENDENT_READY_LOG).
//                jobId(heraActionVo.getJobId()).
////                triggerType(TriggerTypeEnum.SCHEDULE.getId()).
//        triggerType(triggerType.getId()).
//                        operator(heraActionVo.getOwner()).
//                        hostGroupId(heraActionVo.getHostGroupId()).
//                        log(LogConstant.DEPENDENT_READY_LOG).
//                        isNrt(heraActionVo.getIsNrt()).build();
//        masterContext.getHeraJobHistoryService().insert(history);
//        HeraJobHistoryVo historyVo = BeanConvertUtils.convert(history);
//        master.run(historyVo);
//    }
//
//
//    private void handleFailedEvent(HeraJobFailedEvent event) {
//        if (event.getTriggerType() == TriggerTypeEnum.MANUAL) {
//            return;
//        }
//        HeraActionVo heraActionVo = cache.getHeraActionVo();
//        if (heraActionVo == null) {
//            autoRecovery();
//            return;
//        }
//        if(heraActionVo.getId().equals(event.getActionId())) {
//            HeraJobHistoryVo jobHistory = event.getHeraJobHistory();
//            Integer jobId = jobHistory.getJobId();
//            HeraJob heraJob = this.heraJobService.findById(jobId);
//            Integer groupId = heraJob.getGroupId();
//            HeraGroup heraGroup = this.heraGroupService.findById(groupId);
//            Integer alarm = heraGroup.getAlarmStatus();
//            Date endTime = jobHistory.getEndTime();
//            doAlarm(heraJob,alarm,endTime.toString());
//        }
//    }
//
//    /**
//     * 根据组告警策略，区别告警
//     * @param job
//     * @param alarm
//     * @param endTime
//     */
//    private void doAlarm(HeraJob job, Integer alarm,String endTime ) {
//        String jobName = job.getName();
//        String owner = job.getOwner();
//        List<HiracDuty> dutyList = this.hiracDutyService.onDuty();
//        String masterDuty = null;
//        for(HiracDuty duty : dutyList) {
//            if(duty.getRole() == 1) {
//                masterDuty = duty.getName();
//            }
//        }
//        HeraUser master = this.heraUserService.findByName(masterDuty);
//        List<String> emailList = dutyList.stream().map(HiracDuty::getEmail).filter(i -> i != null).collect(Collectors.toList());
//        List<String> phoneList = dutyList.stream().map(HiracDuty::getPhone).filter(i -> i != null).collect(Collectors.toList());
//        String[] watchmen = new String[emailList.size()];
//        String[] watchPhone = new String[phoneList.size()];
//        emailList.toArray(watchmen);
//        phoneList.toArray(watchPhone);
//        String title = String.format("告警|任务|Hirac离线任务|运行失败|@%s",master.getDescription());
//        String content = EmailModelUtils.getAlarmContent(owner,jobName,endTime);
//        String adminContent = EmailModelUtils.getAdminAlarmContent(owner,jobName,endTime);
//        String params =  String.format(VOICE_PARAM,jobName);
//        String ownerEmail = owner + "@hipac.cn";
//        switch(AlarmStatusEnum.getByStatus(alarm)) {
//            case GROUP_EMAIL_ALARM:
//                AlarmUtils.mailResult(title, content, ownerEmail);
//                AlarmUtils.mailAlarm(title,adminContent);
//                break;
//            case GROUP_VOICE_ALARM:
//                AlarmUtils.voiceAlarm(params,watchPhone);
//                break;
//            case GROUP_EMAIL_VOICE_ALARM:
//                AlarmUtils.mailAlarm(title,adminContent);
//                AlarmUtils.voiceAlarm(params,watchPhone);
//                break;
//            case GROUP_ON_DUTY_ALARM:
//                AlarmUtils.mailAlarm(title,adminContent,watchmen);
//                AlarmUtils.voiceAlarm(params,watchPhone);
//                break;
//            case GROUP_CLOSE_ALARM:
//            default:
//                break;
//        }
//    }
//
//    /**
//     * 自动调度执行逻辑，如果没有版本，说明job被删除了，异常情况
//     *
//     * @param event
//     */
//    public void handleTriggerEvent(HeraScheduleTriggerEvent event) {
//        String jobId = event.getJobId();
//        HeraActionVo heraActionVo = cache.getHeraActionVo();
//        if (heraActionVo == null) {
//            autoRecovery();
//            return;
//        }
//        if (!jobId.equals(heraActionVo.getId())) {
//            return;
//        }
//        runJob(heraActionVo);
//    }
//
//    private void runJob(HeraActionVo heraActionVo) {
//        HeraJobHistory history = HeraJobHistory.builder().
//                jobId(heraActionVo.getJobId()).
//                triggerType(TriggerTypeEnum.SCHEDULE.getId()).
//                actionId(heraActionVo.getId()).
//                operator(heraActionVo.getOwner()).
//                hostGroupId(heraActionVo.getHostGroupId()).
//                isNrt(heraActionVo.getIsNrt()).
//                build();
//        masterContext.getHeraJobHistoryService().insert(history);
//        master.run(BeanConvertUtils.convert(history));
//    }
//
//    private void autoRecovery() {
//        cache.refresh();
//        HeraActionVo heraActionVo = cache.getHeraActionVo();
//        //任务被删除
//        if (heraActionVo == null) {
//            masterContext.getDispatcher().removeJobHandler(this);
//            destroy();
//            ScheduleLog.info("heraAction 为空， 删除{}", actionId);
//            return;
//        }
//        //自动调度关闭
//        if (!heraActionVo.getAuto()) {
//            destroy();
//            return;
//        }
//
//        /**
//         * 如果是依赖任务 原来可能是独立任务，需要尝试删除原来的定时调度
//         * 如果是独立任务,则重新创建quartz调度
//         *
//         */
//        if (heraActionVo.getScheduleType() == JobScheduleTypeEnum.Dependent) {
//            destroy();
//        } else if (heraActionVo.getScheduleType() == Independent) {
//            try {
//                createScheduleJob(masterContext.getDispatcher(), heraActionVo);
//            } catch (SchedulerException e) {
//                log.error("createScheduleJob", e);
//            }
//        }
//    }
//
//    private void handleMaintenanceEvent(HeraJobMaintenanceEvent event) {
//        if (event.getType() == Events.UpdateJob && Objects.equals(Integer.parseInt(event.getId()), ActionUtil.getJobId(actionId))) {
//            autoRecovery();
//        }
//        if (event.getType() == Events.UpdateActions && Objects.equals(actionId, event.getId())) {
//            autoRecovery();
//        }
//
//    }
//
//    /**
//     * 漏跑重新触发调度事件
//     *
//     * @param event
//     */
//    private void handleLostEvent(HeraJobLostEvent event) {
//        if (event.getType() == Events.UpdateJob && actionId.equals(event.getJobId())) {
//            HeraActionVo heraActionVo = cache.getHeraActionVo();
//            if (heraActionVo != null) {
//                HeraAction heraAction = heraJobActionService.findById(actionId);
//                if (heraAction != null && StringUtils.isBlank(heraAction.getStatus()) && heraAction.getAuto() == 1) {
//                    if (Long.parseLong(actionId) < Long.parseLong(ActionUtil.getCurrActionVersion())) {
//                        HeraJobHistory history = HeraJobHistory.builder()
//                                .illustrate(LogConstant.LOST_JOB_LOG)
//                                .actionId(heraActionVo.getId())
//                                .jobId(heraActionVo.getJobId())
//                                .triggerType(Integer.parseInt(TriggerTypeEnum.SCHEDULE.toString()))
//                                .statisticEndTime(heraActionVo.getStatisticStartTime())
//                                .operator(heraActionVo.getOwner())
//                                .hostGroupId(heraAction.getHostGroupId())
//                                .isNrt(heraAction.getIsNrt())
//                                .build();
//                        masterContext.getHeraJobHistoryService().insert(history);
//                        master.run(BeanConvertUtils.convert(history));
//                        ScheduleLog.info("lost job, start schedule :{}", actionId);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 创建定时任务
//     *
//     * @param dispatcher   the scheduler
//     * @param heraActionVo the job name
//     */
//
//    private void createScheduleJob(Dispatcher dispatcher, HeraActionVo heraActionVo) throws SchedulerException {
//        if (heraActionVo.getScheduleType() == Independent &&  !ActionUtil.isCurrActionVersion(actionId)) {
//            return;
//        }
//        JobKey jobKey = new JobKey(actionId, Constants.HERA_GROUP);
//        if (masterContext.getQuartzSchedulerService().getScheduler().getJobDetail(jobKey) == null) {
//            JobDetail jobDetail = JobBuilder.newJob(HeraQuartzJob.class).withIdentity(jobKey).build();
//            jobDetail.getJobDataMap().put("actionId", heraActionVo.getId());
//            jobDetail.getJobDataMap().put("dispatcher", dispatcher);
//            //TODO  根据任务区域加时区
//            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(heraActionVo.getCronExpression().trim())/*.inTimeZone()*/;
//            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(actionId, Constants.HERA_GROUP).withSchedule(scheduleBuilder).build();
//            masterContext.getQuartzSchedulerService().getScheduler().scheduleJob(jobDetail, trigger);
//            ScheduleLog.info("--------------------------- 添加自动调度成功:{}--------------------------", heraActionVo.getId());
//        }
//    }
//
//
//    @Override
//    public void destroy() {
//        masterContext.getQuartzSchedulerService().deleteJob(actionId);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof JobHandler)) {
//            return false;
//        }
//        JobHandler jobHandler = (JobHandler) obj;
//        return actionId.equals(jobHandler.getActionId());
//    }
//
//    @Override
//    public int hashCode() {
//        return actionId.hashCode();
//    }
//
//
//}
