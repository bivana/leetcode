package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * */
public class KthLargestElementInAnArray {

    @Test
    public void test(){
        Assert.assertEquals(5,findKthLargest(new int[]{3,2,1,5,6,4},2));
        Assert.assertEquals(4,findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    private Random random=new Random(System.currentTimeMillis());

    /**
     * 官方题解，快速排序
     * */
    public int findKthLargest(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        int target=nums.length-k;
        while (true){
            int pivot=partition(nums,left,right);
            if(pivot==target){
                return nums[pivot];
            }else if(pivot<target){
                left=pivot+1;
            }else if(pivot>target){
                right=pivot-1;
            }
        }
    }



    /**
     * 快速排序查找，随机生成pivot，将比pivot小的数放到左边，比pivot大的数放到右边
     * */
    public int partition(int[] nums,int left,int right){
        //防止right在left左边
        if(right>left){
            int pivot=left+random.nextInt(right-left);
            swap(nums,left,pivot);//先将中心店移到右边
        }
        int j=left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]<nums[left]){
                swap(nums,i,++j);
            }
        }
        swap(nums,left,j);
        return j;
    }



    /*
    * 交换数据
    * */
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void show(int[] nums){
        for(int i:nums){
            System.out.print(i);
        }
        System.out.println();
    }


    /**
     * 排序后去k个
     * */
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
