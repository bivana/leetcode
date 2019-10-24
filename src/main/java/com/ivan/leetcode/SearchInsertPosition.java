package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 在真实的面试中遇到过这道题？
 * */
public class SearchInsertPosition {

    @Test
    public void test(){
        Assert.assertEquals(2,searchInsert(new int[]{1,3,5,6},5));
        Assert.assertEquals(1,searchInsert(new int[]{1,3,5,6},2));
        Assert.assertEquals(4,searchInsert(new int[]{1,3,5,6},7));
        Assert.assertEquals(0,searchInsert(new int[]{1,3,5,6},0));
    }

    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        int mid=0;
        while (left<right){
            mid=(left+right)>>>1;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }

        }
        return left;
    }
}
