package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * */
public class DecodeWays {

    @Test
    public void test(){
        Assert.assertEquals(3,numDecodings("12120"));
        Assert.assertEquals(1,numDecodings("10"));
        Assert.assertEquals(2,numDecodings("12"));
        Assert.assertEquals(3,numDecodings("226"));
        Assert.assertEquals(0,numDecodings("0"));
    }


    Integer[] temp;
    Map<String,String> code;
    public int numDecodings(String s) {

        code=new HashMap<>(26);
        temp=new Integer[s.length()+1];
        for(int i=1;i<=26;i++){
            code.put(i+"",((char)('A'+i-1))+"");
        }
        return numDecoding(s,0);



    }

    private int numDecoding(String s,int startIndex){
        if(temp[startIndex]!=null){
            return temp[startIndex];
        }
        if(s==null||"".equals(s)){
            return 0;
        }
        if(startIndex>=s.length()){
            return 0;
        }
        if(s.length()-startIndex==1 && code.get(s.charAt(startIndex)+"")!=null){
            return 1;
        }
        if(s.length()-startIndex==2 && code.get(s.substring(startIndex))!=null){
            if("10".equals(s.substring(startIndex))||"20".equals(s.substring(startIndex))){
                return 1;
            }
            return 2;
        }
        String first=s.charAt(startIndex)+"";
        if(code.get(first)!=null){
            if(s.length()-startIndex>=2 && code.get(s.substring(startIndex,startIndex+2))!=null){
                temp[startIndex]=numDecoding(s,startIndex+1)+numDecoding(s,startIndex+2);
                return temp[startIndex];
            }else{
                temp[startIndex]=numDecoding(s,startIndex+1);
                return temp[startIndex];
            }
        }
        temp[startIndex]=0;
        return temp[startIndex];
    }
}
