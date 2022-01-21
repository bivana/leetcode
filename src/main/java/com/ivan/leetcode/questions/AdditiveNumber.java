package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 306. 累加数
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 *
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 *
 * 提示：
 *
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 * */
public class AdditiveNumber {

    @Test
    public void test(){
        Assert.assertEquals(false,isAdditiveNumber("1991000199299498797"));
        Assert.assertEquals(false,isAdditiveNumber("0235813"));
        Assert.assertEquals(true,isAdditiveNumber("211738"));
        Assert.assertEquals(true,isAdditiveNumber("123"));
        Assert.assertEquals(true,isAdditiveNumber("112358"));
        Assert.assertEquals(true,isAdditiveNumber("199100199"));
    }

    public boolean isAdditiveNumber(String num) {
        if(num.length()==1){
            return false;
        }
        for(int i=1;i<=num.length()/3+1;i++){
            if(num.charAt(0)=='0'&&i>1){//为0的，只能当前
                break;
            }
            long num1=Long.valueOf(num.substring(0,i));
            for(int size=1;size<=(num.length()-i)/2+1;size++){
                int j=i+size;
                if(num.charAt(i)=='0'&&j>i+1){
                    break;
                }
                long num2=Long.valueOf(num.substring(i,j));
                if(isAdditiveNumber(num1,num2,num.substring(j))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(long num1,long num2,String num){
        long sum=num1+num2;
        String sumStr=sum+"";
        if(num.length()<sumStr.length()){
            return false;
        }else if(!num.startsWith(sumStr)){
            return false;
        }else if(num.length()==sumStr.length()){
            return true;
        }else{
            return isAdditiveNumber(num2,sum,num.substring(sumStr.length()));
        }
    }
}
