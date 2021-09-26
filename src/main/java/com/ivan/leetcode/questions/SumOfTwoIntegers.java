package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 * */
public class SumOfTwoIntegers {

    @Test
    public void test(){
        Assert.assertEquals(3,getSum(1,2));
        Assert.assertEquals(5,getSum(2,3));

    }

    public int getSum(int a, int b) {
        int plus=(a&b)<<1;
        int remain=a^b;
        while (plus!=0){
            int prePlus=plus;
            plus=(remain&prePlus)<<1;
            remain=remain^prePlus;
        }
        return remain;
    }
}
