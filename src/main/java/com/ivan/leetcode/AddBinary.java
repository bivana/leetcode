package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 67. 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 在真实的面试中遇到过这道题？
 * */
public class AddBinary {

    @Test
    public void test(){
        Assert.assertEquals("100",addBinary("11","1"));
        Assert.assertEquals("10101",addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {
        int plus=0;
        StringBuilder sb=new StringBuilder();
        String l=a.length()>=b.length()?a:b;
        String s=a.length()<b.length()?a:b;
        int li=l.length()-1;
        int si=s.length()-1;
        while (li>=l.length()-s.length()){
            int sum=(l.charAt(li--)-'0')+(s.charAt(si--)-'0')+plus;
            plus=sum/2;
            sb.append(sum%2);
        }
        while (li>=0){
            int sum=(l.charAt(li--)-'0')+plus;
            plus=sum/2;
            sb.append(sum%2);
        }
        if(plus==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
