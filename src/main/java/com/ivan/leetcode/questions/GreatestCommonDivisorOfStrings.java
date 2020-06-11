package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * */
public class GreatestCommonDivisorOfStrings {

    @Test
    public void test(){
        Assert.assertEquals("TAUXX",gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        Assert.assertEquals("AB",gcdOfStrings("ABABAB","ABAB"));
        Assert.assertEquals("ABC",gcdOfStrings("ABCABC","ABC"));
        Assert.assertEquals("",gcdOfStrings("LEET","CODE"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if(str1==null || "".equals(str1) || str2==null || "".equals(str2)){
            return "";
        }
        if(str1.length()<str2.length()){
            String temp=str1;
            str1=str2;
            str2=temp;
        }
        String gcd=str1.substring(0,gcd(str1.length(),str2.length()));
        if(isGcd(str1,gcd) && isGcd(str2,gcd)){
            return gcd;
        }
        return "";

    }

    public boolean isGcd(String str1,String str2){
        if(str1.length()%str2.length()!=0){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i%str2.length())){
                return false;
            }
        }
        return true;
    }

    public  int gcd(int a,int b) {
        int n = 0;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

}
