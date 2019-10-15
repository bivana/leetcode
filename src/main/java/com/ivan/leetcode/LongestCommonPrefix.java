package com.ivan.leetcode;

import junit.framework.Assert;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * */
public class LongestCommonPrefix {

    public static void main(String[] args){
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        Assert.assertEquals("fl",longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Assert.assertEquals("",longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int i=0;
        while (true){
            String temp=null;
            for(String s:strs){
                if(i>=s.length()){
                    return s.substring(0,i);
                }else{
                    if(temp==null){
                        temp=s.charAt(i)+"";
                    }else{
                        if(temp.equals(s.charAt(i)+"")){

                        }else{
                            return s.substring(0,i);
                        }
                    }
                }
            }
            i++;
        }
    }
}
