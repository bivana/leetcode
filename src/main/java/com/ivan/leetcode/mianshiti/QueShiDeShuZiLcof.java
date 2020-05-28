package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 通过次数18,743提交次数41,811
 * 在真实的面试中遇到过这道题？
 * */
public class QueShiDeShuZiLcof {

    @Test
    public void test(){
        Assert.assertEquals(1,missingNumber(new int[]{0}));
        Assert.assertEquals(2,missingNumber(new int[]{0,1}));
        Assert.assertEquals(2,missingNumber(new int[]{0,1,3}));
        Assert.assertEquals(8,missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }

    public int missingNumber(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >>>1;
            if(nums[mid] == mid) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
