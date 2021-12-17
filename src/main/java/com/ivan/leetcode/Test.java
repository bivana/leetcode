package com.ivan.leetcode;

import java.time.LocalDateTime;

public class Test {

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
        Test test=new Test();
        test.test();
    }


    public void test() throws InterruptedException {
    }



    class ThreadPrint1 extends Thread{
        @Override
        public void run() {
            int ans=Integer.parseInt("1");
            System.out.println("线程1打印parse，结果为:"+ans);
        }
    }

}
