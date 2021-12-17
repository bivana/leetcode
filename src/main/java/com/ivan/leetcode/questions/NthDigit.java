package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 通过次数24,599提交次数56,381
 * */
public class NthDigit {

    @Test
    public void test(){
//        Assert.assertEquals(3,findNthDigit(3));
        Assert.assertEquals(0,findNthDigit(11));
    }

    /**
     * 1*9 + 2*10*9 +3*100*9 +4*1000*9
     *
     * 9 * (1+2*10+3*100+4*1000)
     *
     * 所以有  n/9 确认位数
     * */
    public int findNthDigit(int n) {
        int i=1;//一共有n位
        int curTotal=0;//当期总数
        int remain=n;
        while (remain>(curTotal=(int)(i*9*Math.pow(10,(i-1))))){
            remain=remain-curTotal;
            i++;
        }
        int num=(int)Math.pow(10,i-1)+(remain-1)/i;
        int finalRemain=(remain-1)%i;//最后第几位
        int ans=Integer.valueOf(Integer.valueOf(num).toString().charAt(finalRemain)+"");
        return ans;
    }

    public static void main(String[] args){
        System.out.println(Math.log10(1));
    }
}
