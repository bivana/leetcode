package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 在真实的面试中遇到过这道题？
 * */
public class PlusOne {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,2,4},plusOne(new int[]{1,2,3}));
        Assert.assertArrayEquals(new int[]{4,3,2,2},plusOne(new int[]{4,3,2,1}));
        Assert.assertArrayEquals(new int[]{1,0,0},plusOne(new int[]{9,9}));
    }

    public int[] plusOne(int[] digits) {
        int plus=1;
        for(int i=digits.length-1;i>=0;i--){
            //只有9会进位
            if(digits[i]==9 && plus==1){
                digits[i]=0;
                plus=1;
            }else{
                digits[i]=digits[i]+1;
                plus=0;
                break;
            }
        }
        //结果为1000...格式
        if(plus==1){
            digits=new int[digits.length+1];
            digits[0]=1;
        }
        return digits;
    }
}
