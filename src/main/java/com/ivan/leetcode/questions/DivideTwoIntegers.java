package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * */
public class DivideTwoIntegers {

    @Test
    public void test(){
        Assert.assertEquals(3,divide(10,3));
        Assert.assertEquals(-2,divide(7,-3));
    }

    /**
     * 备减法
     * */
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){//超出了
            return Integer.MAX_VALUE;
        }
        int flag=1;//1表示正式，0 表示负数

        //将dividend和divisor 变为负数，并记下正负号
        if(dividend>0){
            dividend=-dividend;
        }else{
            flag=-flag;
        }
        if(divisor>0){
            divisor=-divisor;
        }else{
            flag=-flag;
        }

        int s=0;
        while (dividend<=divisor){//因为都是负数，所以被除数要<=除数
            int tmp=divisor;//一次减多少
            int k=1;//一共有几层
            while (dividend<=tmp+tmp && tmp+tmp<0){
                tmp+=tmp;
                k+=k;
            }
            dividend=dividend-tmp;
            s=s+k;
        }
        return flag==1?s:-s;
    }

//    public int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//
//        int flag = 1; // 1 表示正数，-1表示负数；
//        if (dividend > 0) {
//            dividend = -dividend;
//        } else {
//            flag = -flag;
//        }
//        if (divisor > 0) {
//            divisor = -divisor;
//        } else {
//            flag = -flag;
//        }
//
//        int s = 0, tmpd, k;
//        while (dividend <= divisor) {
//            tmpd = divisor;
//            k = 1;
//            while (dividend <= tmpd + tmpd && tmpd + tmpd < 0) {
//                tmpd += tmpd;
//                k += k;
//            }
//            s = s + k;
//            dividend -= tmpd;
//        }
//        return flag > 0 ? s : -s;
//    }
}
