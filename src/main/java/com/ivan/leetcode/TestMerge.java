package com.ivan.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestMerge {

    public static void main(String[] args) throws InterruptedException {
//        LocalDateTime now = LocalDateTime.now();
//        int actrueMinute = now.getMinute();
//        int actrueHour = now.getHour();
//        int actrueDay = now.getDayOfMonth();
//        System.out.println(actrueMinute);
//        System.out.println(actrueHour);
//        System.out.println(actrueDay);
//        String s;s.split()
//        String[] s="0 0 0 1 12 ?".trim().split("\\s");
//        System.out.println(s);
//        Test test=new Test();
//        test.test();
    }

    @Test
    public void test(){
        //测试用例1 【商详->PageA->商详】 合并 <br/>
        testMergeDAD();
        //测试用例2 【A商详->PageA->B商详】 不进行合并
        testMergeDaADb();
    }

    /**
     * 测试用例1 【商详->PageA->商详】 合并 <br/>
     * 输入：  [{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033","item_id":"275272"},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","item_id":"275272"},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","item_id":"275272"}] <br/>
     * 输出： [{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033","log_id_list":["000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033","000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039"]}]
     * */
    @Test
    public void testMergeDAD(){
        String input="[{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\",\"item_id\":\"275272\"},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"item_id\":\"275272\"},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"item_id\":\"275272\"}]";
        String expect="[{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\",\"log_id_list\":[\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\",\"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\"]}]";
        Assert.assertEquals(expect,merge(input));
    }

    /**
     * 测试用例2 【A商详->PageA->B商详】 不进行合并 <br/>
     * 输入：  [{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033","item_id":"275272"},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","item_id":"275272"},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","item_id":"275273"}]
     * <br/>
     * 输出： [{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033","log_id_list":["000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033"]},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039","log_id_list":["000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039"]},{"log_id":"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039"}]
     * */
    @Test
    public void testMergeDaADb(){
        String input="[{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\",\"item_id\":\"275272\"},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"item_id\":\"275272\"},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"item_id\":\"275273\"}]";
        String expect="[{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\",\"log_id_list\":[\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350033\"]},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\",\"log_id_list\":[\"000301fc1deb4cd592c0544d95bf5efa#6.4.49.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\"]},{\"log_id\":\"000301fc1deb4cd592c0544d95bf5efa#6.4.3.0.0#91AA3B4D-6725-4DFB-8F59-384F8D1A03A0_tongdun#1641349350039\"}]";
        Assert.assertEquals(expect,merge(input));
    }


    /**
     * 合并商详页，当用户对商详页的操作在一分钟内，且操作栈深度不超过4时，进行合并 <br/>
     * 对一下场景进行合并 <br/>
     * 例子一： 【itemA商详->PageB->itemA商详】 -> 【itemA商详】 <br>
     * 例子二： 【itemA商详->PageB->PageC->PageB->itemA商详】 -> 【itemA商详】 <br>
     * 对以下场景不进行合并 <br/>
     * 例子一： 【itemA商详->PageB->PageC->PageD->itemA商详】 -> 【itemA商详】 <br>
     * 解释：链路【PageB->PageC->PageD没有形成回退操作，对第二个itemA商详来说，来源为PageD】
     * @param logRecordsStr 商详页记录字符串，格式为【[{"log_id":"xxx","item_id":"xxx"},{"log_id":"xxx","item_id":"xxx"}]】
     * @return 合并后的结果字符串，格式为【[{"log_id":"xxx","merge_lod_ids":"id1,id2,id3"},{"log_id":"xxx","merge_lod_ids":"id1,id2,id3"}]】
     * */
    public String merge(String logRecordsStr)  {
        List<LogRecord> list=parseToLogRecord(logRecordsStr);
        //排序
        Collections.sort(list);
        MergeOp mergeOp=new MergeOp(list);

        List<LogRecord> rs=mergeOp.merge();

        return JSON.toJSONString(rs);
    }


    private List<LogRecord> parseToLogRecord(String s){
        JSONArray jsonArray= JSONArray.parseArray(s);
        List<LogRecord> list=new ArrayList<LogRecord>(jsonArray.size());
        for(Object jsonObject:jsonArray.toArray()){
            list.add(new LogRecord((JSONObject) jsonObject));
        }
        return list;
    }

    /**
     * merge操作，一些变量需要重复使用
     * */
    class MergeOp{
        //双指针，i为本轮尝试折叠的，j为向后尝试折叠的
        int i=0;
        int j=0;
        //栈，用户存储当前用户的访问操作
        Deque<LogRecord> deque=new ArrayDeque<LogRecord>();

        //合并前待合并记录
        List<LogRecord> list;

        //合并后的结果
        List<LogRecord> rs=new ArrayList<LogRecord>();

        public MergeOp(List<LogRecord> list){
            this.list=list;
        }

        /**
         * 合并操作
         * */
        public List<LogRecord> merge(){
            while (j<list.size()){
                LogRecord logRecord=list.get(j);

                //队列为0，表示新的循环开始
                if(deque.size()==0){
                    //如果是商详页，那么放入队列中，继续循环下游查看是否可以合并
                    if(logRecord.getCode().equals("6.4.3.0.0")){
                        deque.push(logRecord);
                        j++;
                    }else{//如果不为商详页，那么直接不进行合并
                        notMerge(logRecord);
                    }
                }else{//不是新的开始，在判断是否可以合并
                    LogRecord start=deque.peekFirst();
                    //如果超出了一分钟，那么不进行合并了，将start放入结果，清除队列，并重新开始
                    if(logRecord.getRequestTimeStamp()-start.getRequestTimeStamp()>60*1000){
                        notMerge(start);
                    }
                    //商详页
                    if(logRecord.getCode().equals("6.4.3.0.0")){
                        //判断是否可以折叠，可合并的标准为用户标准的回退操作
                        //这里deque为2的场景为 【商详页->页面A】 商详页
                        //deque为1的场景为 【商详页】 商详页
                        //可以折叠，从i折叠到j
                        if(deque.size()<=2&&StringEquals(logRecord.getItemId(),start.getItemId())){
                            merge(start);
                        }else{
                            //不可折叠,将start放入结果，清除缓存
                            notMerge(start);
                        }
                    }else{
                        //不为商详页
                        //栈深度不超过4个，放入队列,j++
                        if(deque.size()<4){
                            deque.add(logRecord);
                            j++;
                        }else{
                            //超出了，不进行合并
                            notMerge(start);
                        }
                    }

                }
            }
            //最后一个合并了的，但是没有放入结果集
            if(i==list.size()-1&&deque.size()==1){
                rs.add(deque.pollFirst());
            }
            return rs;
        }

        //防止字符串为空无法判断
        private boolean StringEquals(String a,String b){
            if(a==null&&b==null){
                return true;
            }else if(a==null){
                return false;
            }else{
                return a.equals(b);
            }
        }

        private void merge(LogRecord logRecord){
            setLogList(list,i,j,logRecord);
            i=j;
            j++;
            deque.clear();
            deque.push(logRecord);
            list.set(i,logRecord);
        }

        //不进行合并
        private void notMerge(LogRecord logRecord){
            setLogList(list,i,i,logRecord);
            rs.add(logRecord);
            i++;
            j=i;
            deque.clear();
        }

        private void setLogList(List<LogRecord> list,int start,int end,LogRecord logRecord){
            if(logRecord.getLogIdList()==null){
                List<String> logIdList=new ArrayList<String>();
                logIdList.add(list.get(start).getLogId());
                logRecord.setLogIdList(logIdList);
            }
            for(int i=start+1;i<=end;i++){
                logRecord.getLogIdList().add(list.get(i).getLogId());
            }
        }

    }

    /**
     * 日志记录对象
     */
    class LogRecord implements Comparable<LogRecord>{
        @JSONField(name = "log_id")
        private String logId;
        @JSONField(serialize = false)
        private String uid;
        @JSONField(serialize = false)
        private String code;
        @JSONField(serialize = false)
        private String deviceNo;
        @JSONField(serialize = false)
        private Long requestTimeStamp;
        @JSONField(serialize = false)
        private String itemId;
        @JSONField(name = "log_id_list")
        private List<String> logIdList;

        public LogRecord(JSONObject logJson){
            if(logJson==null){
                return;
            }
            String logId=logJson.getString("log_id");
            this.setLogId(logId);
            String[] array=logId.split("#");
            checkArg(array);
            String itemId=logJson.getString("item_id");
            this.setItemId(itemId);
            this.setUid(array[0]);
            this.setCode(array[1]);
            this.setDeviceNo(array[2]);
            this.setRequestTimeStamp(Long.parseLong(array[3]));
        }

        private void checkArg(String[] logArray){
            if(logArray.length!=4){
                throw new IllegalArgumentException("字符串不符合预期,log_id期望格式为【uid#code#device_no#timestamp】，请确认格式!");
            }
            if(logArray[3]==null||logArray[3].equals("")){
                throw new IllegalArgumentException("log_id中的timestamp不允许为空");
            }
            if(logArray[3].length()!=13){
                throw new IllegalArgumentException("log_id中的timestamp格式非法，请输入长度为13的时间戳");
            }
        }

        public String getLogId() {
            return logId;
        }

        public void setLogId(String logId) {
            this.logId = logId;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDeviceNo() {
            return deviceNo;
        }

        public void setDeviceNo(String deviceNo) {
            this.deviceNo = deviceNo;
        }

        public Long getRequestTimeStamp() {
            return requestTimeStamp;
        }

        public void setRequestTimeStamp(Long requestTimeStamp) {
            this.requestTimeStamp = requestTimeStamp;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public List<String> getLogIdList() {
            return logIdList;
        }

        public void setLogIdList(List<String> logIdList) {
            this.logIdList = logIdList;
        }

        public int compareTo(LogRecord o) {
            return this.getRequestTimeStamp().compareTo(o.getRequestTimeStamp());
        }
    }



}
