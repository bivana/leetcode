package com.ivan.leetcode;

import junit.framework.Assert;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class IntegerPalindrome {
    public static void main(String[] args){
        IntegerPalindrome integerPalindrome=new IntegerPalindrome();
//        Assert.assertEquals(true,integerPalindrome.isPalindrome(121));
//        Assert.assertEquals(false,integerPalindrome.isPalindrome(-121));
//        Assert.assertEquals(false,integerPalindrome.isPalindrome(10));
//        Assert.assertEquals(true,integerPalindrome.isPalindrome(313));
//        Assert.assertEquals(false,integerPalindrome.isPalindrome(1000021));
//        Assert.assertEquals(true,integerPalindrome.isPalindrome(0));
//        Assert.assertEquals(true,integerPalindrome.isPalindrome(1));
//        Assert.assertEquals(true,integerPalindrome.isPalindrome(1001));
        Assert.assertEquals(false,integerPalindrome.isPalindrome(100000111));

    }
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
