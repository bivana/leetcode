package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 537. 复数乘法
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 *
 * 提示：
 *
 * num1 和 num2 都是有效的复数表示。
 * */
public class ComplexNumberMultiplication {

    @Test
    public void test(){
        Assert.assertEquals("0+2i",complexNumberMultiply("1+1i","1+1i"));
        Assert.assertEquals("0+-2i",complexNumberMultiply("1+-1i","1+-1i"));
    }

    public String complexNumberMultiply(String num1, String num2) {
        String[] nums1=num1.split("\\+");
        String[] nums2=num2.split("\\+");
        Integer real1=Integer.parseInt(nums1[0]);
        Integer imagenary1=Integer.valueOf(nums1[1].substring(0,nums1[1].length()-1));
        Integer real2=Integer.parseInt(nums2[0]);
        Integer imagenary2=Integer.valueOf(nums2[1].substring(0,nums2[1].length()-1));
        Integer real=real1*real2-imagenary1*imagenary2;
        Integer imagenary=real1*imagenary2+real2*imagenary1;
        return real+"+"+imagenary.toString()+"i";
    }
}
