package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1108. IP 地址无效化
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *  
 *
 * 提示：
 *
 * 给出的 address 是一个有效的 IPv4 地址
 * */
public class DefangingAnIpAddress {

    @Test
    public void test(){
        Assert.assertEquals("1[.]1[.]1[.]1",defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0",defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        StringBuilder sb=new StringBuilder();
        for(char c:address.toCharArray()){
            if(c=='.'){
                sb.append("[.]");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
