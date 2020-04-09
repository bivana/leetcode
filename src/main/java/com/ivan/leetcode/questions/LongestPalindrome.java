package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * */
public class LongestPalindrome {

    @Test
    public void test(){
        Assert.assertEquals(7,longestPalindrome("abccccdd"));

    }

    /**
     *
     * */
    public int longestPalindrome(String s) {
        if(s==null||s.length()<=0){
            return 0;
        }
        int[] temp=new int[58];
        for(char c:s.toCharArray()){
            temp[c-'A']+=1;
        }
        int ans=0;
        for(int i:temp){
            if(i!=0){
                ans+=i-(i&1);
            }

        }
        return ans<s.length()?ans+1:ans;
    }
}
