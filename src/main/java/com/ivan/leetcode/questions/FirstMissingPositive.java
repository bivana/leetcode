package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * 41. 缺失的第一个正数
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * */
public class FirstMissingPositive {

    @Test
    public void test(){
        Assert.assertEquals(2,firstMissingPositive(new int[]{1,1}));

        Assert.assertEquals(3,firstMissingPositive(new int[]{1,2,0}));
        Assert.assertEquals(2,firstMissingPositive(new int[]{3,4,-1,1}));
        Assert.assertEquals(1,firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            //如果不相等
            //如果i在范围内，替换
            while (nums[i]!=i+1 && nums[i]>=1 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }
//            ShowUtil.showIntArray(nums);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums[nums.length-1]+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
