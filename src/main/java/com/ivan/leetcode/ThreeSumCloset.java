package com.ivan.leetcode;

import junit.framework.Assert;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 *
 * */
public class ThreeSumCloset {

    public static void main(String[] args){
        ThreeSumCloset threeSumCloset=new ThreeSumCloset();
        Assert.assertEquals(2,threeSumCloset.threeSumClosest(new int[]{-1,2,1,-4},1));
        Assert.assertEquals(3,threeSumCloset.threeSumClosest(new int[]{1,1,1,1},0));
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left != right){
                int min = nums[i] + nums[left] + nums[left + 1];
                if(target < min){
                    if(Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if(target > max){
                    if(Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if(sum == target)
                    return sum;
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if(sum > target){
                    right--;
                    while(left != right && nums[right] == nums[right+1])
                        right--;
                }
                else{
                    left++;
                    while(left != right && nums[left] == nums[left-1])
                        left++;
                }
            }
            while(i<nums.length-2 && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }

//    public int threeSumClosest(int[] nums, int target) {
//        Integer result=null;
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length-2;i++){
//            int l=i+1;
//            int r=nums.length-1;
//            if(i>0 && nums[i]==nums[i-1]){
//                continue;
//            }else {
//                while (l<r){
//                    int temp=nums[i]+nums[l]+nums[r]-target;
//                    if(result==null){
//                        result=temp;
//                    }else{
//                        result=Math.abs(temp)<Math.abs(result)?temp:result;
//                    }
//                    if(temp==0){
//                        return target;
//                    }else if(temp>0){
//                        while(l < r && nums[r] == nums[--r]);
//                    }else{
//                        while(l < r && nums[l] == nums[++l]);
//                    }
//                }
//            }
//        }
//        return result+target;
//    }
}
