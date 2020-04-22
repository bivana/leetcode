package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 面试题03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 * */
public class ShuZuZhongZhongFuDeShuZiLcof {

    @Test
    public void test(){
        Assert.assertEquals(2,findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);
        for(int num:nums){
            if(memo[num]!=-1){
                return num;
            }
            memo[num]=num;
        }
        return Integer.MIN_VALUE;

    }
}
