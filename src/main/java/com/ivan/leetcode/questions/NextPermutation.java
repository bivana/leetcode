package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * */
public class NextPermutation {

    @Test
    public void test(){
        int[] a=null;

        a=new int[]{2,3,1};
        nextPermutation(a);
        Assert.assertArrayEquals(new int[]{3,1,2},a);

        a=new int[]{1,3,2};
        nextPermutation(a);
        Assert.assertArrayEquals(new int[]{2,1,3},a);

        a=new int[]{1,2,3};
        nextPermutation(a);
        Assert.assertArrayEquals(new int[]{1,3,2},a);

        a=new int[]{3,2,1};
        nextPermutation(a);
        Assert.assertArrayEquals(new int[]{1,2,3},a);

        a=new int[]{1,1,5};
        nextPermutation(a);
        Assert.assertArrayEquals(new int[]{1,5,1},a);
    }

    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int i=nums.length-2;
        // 先行查找出要交换的点
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            //在查找出待交换的点
            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while (i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
