package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 * */
public class ValidPerfectSquare {

    @Test
    public void test(){
        Assert.assertEquals(true,isPerfectSquare(808201));
        Assert.assertEquals(false,isPerfectSquare(2147483647));
        Assert.assertEquals(true,isPerfectSquare(16));
        Assert.assertEquals(false,isPerfectSquare(12));
        Assert.assertEquals(true,isPerfectSquare(9));
    }

//    public boolean isPerfectSquare(int num) {
//        int left = 0, right = num;
//        while (left <= right) {
//            int mid = (right - left) / 2 + left;
//            long square = (long) mid * mid;
//            if (square < num) {
//                left = mid + 1;
//            } else if (square > num) {
//                right = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }


    public boolean isPerfectSquare(int num) {
        int l=1;
        int r=num;
        while (l<r){
            int mid=(r-l)/2+l;
            if((long)mid*mid<num){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return ((long)l*l)==num;

    }
}
