package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 通过次数30,877提交次数60,820
 * 在真实的面试中遇到过这道题？
 * */
public class DecodeString {

    @Test
    public void test(){
        Assert.assertEquals("accaccacc",decodeString("3[a2[c]]"));
        Assert.assertEquals("aaabcbc",decodeString("3[a]2[bc]"));
        Assert.assertEquals("abcabccdcdcdef",decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        int start=-1;
        int end=-1;
        int count=0;
        int numStart=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                count++;
                if(start==-1){
                    start=i;
                }
            }else if(s.charAt(i)==']'){
                count--;
                if(count==0 && end==-1){
                    end=i;
                    break;
                }
            }else if(s.charAt(i)>='0' && s.charAt(i)<='9' && numStart==-1){
                numStart=i;
            }
        }
        if(start==-1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        if(numStart!=0){
            sb.append(s.substring(0,numStart));
        }
        int repeat=Integer.parseInt(s.substring(numStart,start));
        String sub=decodeString(s.substring(start+1,end));
        for(int i=0;i<repeat;i++){
            sb.append(sub);
        }
        if(end<s.length()-1){
            sb.append(decodeString(s.substring(end+1)));
        }
        return sb.toString();
    }
}
