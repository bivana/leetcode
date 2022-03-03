package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 *
 * 输入: num = 0
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 *
 *
 * 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 * */
public class AddDigits {

    @Test
    public void test(){
        Assert.assertEquals(1,addDigits(100));
        Assert.assertEquals(2,addDigits(38));
        Assert.assertEquals(0,addDigits(0));
    }

    public int addDigits(int num) {
        int sum=0;
        while (num>0){
            if(num>=10){
                sum+=(num%10);
                num=num/10;
            }else{
                sum+=num;
                if(sum>=10){
                    num=sum;
                    sum=0;
                }else{
                    return sum;
                }
            }
        }
        return sum;
    }
}
