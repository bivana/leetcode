package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * */
public class ImplementStrstr {

    @Test
    public void test(){
        System.out.println(strStr("mississippi","issipi"));
        Assert.assertEquals(2,strStr("hello","ll"));
        Assert.assertEquals(-1,strStr("aaaaa","bba"));
        Assert.assertEquals(-1,strStr("aaa","aaaa"));
    }

    public int strStr(String haystack, String needle) {
        haystack.indexOf(needle);
        if(needle==null || needle.equals("")){
            return 0;
        }
        if(haystack==null || haystack.equals("")){
            return -1;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while (j<needle.length()){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    j++;
                }else{
                    break;
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
