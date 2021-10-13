package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4：
 *
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 * */
public class IntegerToEnglishWords {

    @Test
    public void test(){
        Assert.assertEquals("One Hundred Twenty Three",numberToWords(123));
        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five",numberToWords(12345));
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",numberToWords(1234567));
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",numberToWords(1234567891));
    }

    public String numberToWords(int num) {
        return null;
    }
}
