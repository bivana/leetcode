package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 通过次数39,920提交次数85,702
 * */
public class RestoreIpAddresses {

    @Test
    public void test(){
        Assert.assertArrayEquals(new String[]{"0.10.0.10","0.100.1.0"},restoreIpAddresses("010010").toArray(new String[]{}));

        Assert.assertArrayEquals(new String[]{"0.0.0.0"},restoreIpAddresses("0000").toArray(new String[]{}));

        Assert.assertArrayEquals(new String[]{"255.255.11.135", "255.255.111.35"},restoreIpAddresses("25525511135").toArray(new String[]{}));
    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        Deque<String> temp = new ArrayDeque<>(4);
        backTrace(s, 0,temp,res);
        return res;
    }

    private void backTrace(String s,int start,Deque<String> temp,List<String> res){
        int len=s.length()-start;
        int remain=4-temp.size();
        if(len<remain||len>3*remain){//无法取得的情况
            return;
        }
        if(temp.size()!=0){
            String last=temp.peekLast();
            //检验三位数ip的合法性
            if(last.startsWith("0")&&last.length()>1){
                return;
            }
            if(Integer.parseInt(last)>255){
                return;
            }
        }
        if(temp.size()==4 && start==s.length()){//满足条件，清空temp
            res.add(String.join(".",temp));
            return;
        }

        //一共有3种情况可以尝试
        for(int i=0;i<3 && start+i+1<=s.length();i++){
            temp.add(s.substring(start,start+i+1));
            backTrace(s,start+i+1,temp,res);
            temp.removeLast();
        }
    }



}
