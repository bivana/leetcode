package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * 通过次数9,996提交次数14,819
 * */
public class CheckPermutationLcci {

    @Test
    public void test(){
        Assert.assertEquals(true,CheckPermutation("abc","bca"));
        Assert.assertEquals(false,CheckPermutation("abc","bad"));
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1==null||s2==null){
            return false;
        }
        int[] count=new int[127];
        for(char c:s1.toCharArray()){
            count[c]++;
        }
        for(char c:s2.toCharArray()){
            count[c]--;
        }
        for(int num:count){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
