package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 * 通过次数29,379提交次数54,154
 * */
public class BaShuZiFanYiChengZiFuChuanLcof {

    @Test
    public void test(){
        Assert.assertEquals(5,translateNum(12258));
    }

    // 转移方程 f(x)=f()
    public int translateNum(int num) {

        int len=(int)Math.ceil(Math.log10(num));
        System.out.println(len);
        return 0;
    }
}
