package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 *
 * 提示：
 *
 * -107 <= num <= 107
 * */
public class Base7 {

    @Test
    public void test(){
        Assert.assertEquals("110",convertToBase7(56));
        Assert.assertEquals("0",convertToBase7(0));
        Assert.assertEquals("202",convertToBase7(100));
        Assert.assertEquals("-10",convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        int direction=1;
        if(num<0){
            direction=-1;
            num=-num;
        }else if(num==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        int to=1;
        while (num>0){
            int remain=num%(to*7);
            sb.insert(0,remain/to);
            num=num-remain;
            to=to*7;
        }
        if(direction==-1){
            sb.insert(0,"-");
        }
        return sb.toString();
    }
}
