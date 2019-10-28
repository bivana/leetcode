package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 在真实的面试中遇到过这道题？
 * */
public class SearchInRotatedSortedArray {

    @Test
    public void test(){
//        Assert.assertEquals(4,search(new int[]{4,5,6,7,0,1,2},0));
//        Assert.assertEquals(-1,search(new int[]{4,5,6,7,0,1,2},3));
//        Assert.assertEquals(1,search(new int[]{1,3},3));
        Assert.assertEquals(0,search(new int[]{5,1,3},5));
    }

    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=(start+end)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                if(nums[start]>target){
                    start=mid+1;
                }else{
                    end=mid;
                }
            }
        }
        if(nums[start]==target){
            return start;
        }
        return -1;
    }
}
