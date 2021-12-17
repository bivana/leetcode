package com.ivan.leetcode;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPrintInteger extends Thread{

    private String cronExpression;

    private LocalDateTime now;

    public static void main(String[] args) throws Exception{
        ThreadPrintInteger t=new ThreadPrintInteger();
        t.test();
    }

    public void test() throws Exception{
        String cronExpression="2021";
        ExecutorService threadPoolExecutor= Executors.newCachedThreadPool();
        threadPoolExecutor.submit(new ThreadPrintInteger("0 0 0 1 12 ?",LocalDateTime.of(2021,12,1,0,1)));
        threadPoolExecutor.submit(new ThreadPrintInteger("0 0 0 30 11 ?",LocalDateTime.of(2021,11,30,1,2)));
        threadPoolExecutor.submit(new ThreadPrintInteger("0 0 0 1 12 ?",LocalDateTime.of(2021,12,1,0,0)));
        threadPoolExecutor.submit(new ThreadPrintInteger("0 0 0 1 10 ?",LocalDateTime.of(2021,10,1,5,5)));
        threadPoolExecutor.submit(new ThreadPrintInteger("0 0 0 8 9 ?",LocalDateTime.of(2021,9,8,2,1)));
        Thread.sleep(1000000);
//        for(int i=0;i<100;i++){
//            threadPoolExecutor.submit(new ThreadPrintInteger(cronExpression,now));
//        }
    }

    public ThreadPrintInteger(){
        super();
    }

    public ThreadPrintInteger( String cronExpression,LocalDateTime now){
        this.cronExpression=cronExpression;
        this.now=now;
    }

    @Override
    public void run() {
        while (true){
            boolean ans=ThreadPrintInteger.isOvertime(cronExpression,now);
            if(!ans){
                System.out.println(cronExpression+"期望为:"+true+"，结果为："+ans);
            }else{
//                System.out.println("true");
//                try {
//                    Thread.sleep(1000);
//                }catch (Exception e){
//
//                }

            }
//                System.out.println(ans);
        }

//            StringBuffer sb=new StringBuffer();
//            sb.append("线程").append(intStr).append("打印parse,结果为:").append(ans);
    }

    private static Boolean isOvertime(String cronExpression,LocalDateTime now) {
        String[] crontab = cronExpression.trim().split("\\s");
        int minute = Integer.parseInt(crontab[1]);
        int hour = Integer.parseInt(crontab[2]);
        int day = Integer.parseInt(crontab[3]);
        int actrueMinute = now.getMinute();
        int actrueHour = now.getHour();
        int actrueDay = now.getDayOfMonth();
        if(actrueDay == day) {
            if(actrueHour > hour) {
                return true;
            }
            if(actrueHour == hour) {
                if(actrueMinute >= minute) {
                    return true;
                }
                return minute - actrueMinute == 1;
            } else {
                return false;
            }
        }

        return false;
    }
}
