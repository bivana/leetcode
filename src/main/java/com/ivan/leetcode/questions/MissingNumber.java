package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 268. 缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * */
public class MissingNumber {

    @Test
    public void test(){
        Assert.assertEquals(2,missingNumber(new int[]{0,1}));
        Assert.assertEquals(1,missingNumber(new int[]{0}));
        Assert.assertEquals(2,missingNumber(new int[]{3,0,1}));
        Assert.assertEquals(8,missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public int missingNumber(int[] nums) {
        int index=-1;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i && nums[i]<nums.length){
                change(nums,i,nums[i]);
            }
            if(nums[i]>=nums.length){
                index=i;
            }
        }
        if(index==-1){
            return nums.length;
        }
        return index;
    }

    public void change(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
