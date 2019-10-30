package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * */
public class FindFirstAndLastPositionOfElementInSortedArray {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{0,0},searchRange(new int[]{1},1));
        Assert.assertArrayEquals(new int[]{3,4},searchRange(new int[]{5,7,7,8,8,10},8));
        Assert.assertArrayEquals(new int[]{-1,-1},searchRange(new int[]{5,7,7,8,8,10},6));
    }

//    public int[] searchRange(int[] nums, int target) {
//        int[] rs =new int[]{-1,-1};
//        int left=0;
//        int right=nums.length-1;
//        int index=-1;
//        while (left<=right){
//            int mid=(left+right)>>>1;
//            if(nums[mid]==target){
//                index=mid;
//                break;
//            }else if(nums[mid]<target){
//                left=mid+1;
//            }else{
//                right=mid-1;
//            }
//        }
//        if(index!=-1){
//            left=index;
//            while (--left>=0 && nums[left]==target);
//            rs[0]=left+1;
//            right=index;
//            while (++right<=nums.length-1&&nums[right]==target);
//            rs[1]=right-1;
//        }
//        return rs;
//    }

    public int[] searchRange(int[] nums, int target) {
        int[] rs =new int[]{-1,-1};
        rs[0]=searchLeft(nums,target);
        rs[1]=searchRight(nums,target);
        return rs;
    }

    private int searchLeft(int[] nums,int target){
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(left==nums.length){
            return -1;
        }
        return nums[left]==target?left:-1;
    }

    private int searchRight(int[] nums,int target){
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(left==0){
            return -1;
        }
        return nums[left-1]==target?left-1:-1;
    }
}
