package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 * */
public class PowerOfTwo {

    @Test
    public void test(){
        Assert.assertEquals(true,isPowerOfTwo(1));
        Assert.assertEquals(true,isPowerOfTwo(16));
        Assert.assertEquals(false,isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }

//    public boolean isPowerOfTwo(int n) {
//        if(n<=0){
//            return false;
//        }
//        while (n>1){
//            if((n&1)==1){
//                return false;
//            }
//            n=n>>1;
//        }
//        return true;
//    }
}
