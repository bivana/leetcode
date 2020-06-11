package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * */
public class SortAnArray {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,2,3,5},sortArray(new int[]{5,2,3,1}));
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,5},sortArray(new int[]{5,1,1,2,0,0}));
    }

    /**
     * 快速排序
     * */
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left>=right){
            return;
        }
        int low=left+1;
        int high=right;
        while (low<=high){
            if(nums[low]>nums[left]){
                swap(nums,low,high);
                high--;
            }else {
                low++;
            }
        }
        low--;
        swap(nums,low,left);
        quickSort(nums,left,low-1);
        quickSort(nums,low+1,right);
    }

    private void quickSort2(int[] nums, int left, int right) {
        if (left>=right) return;
        int cur = left + 1;                   // 从左侧第二个元素开始
        int lo = left;                        // 分界点为第一个元素
        while (cur <= right) {
            if (nums[cur] <= nums[left]) {    // 交换位置保证lo的左侧都是小于num[left]
                swap(nums, lo+1, cur);
                lo ++;
            }
            cur++;
        }
        swap(nums, left, lo);                 // 把分界点元素移动到新的分界位置
        quickSort2(nums, left, lo-1);
        quickSort2(nums, lo+1, right);
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
