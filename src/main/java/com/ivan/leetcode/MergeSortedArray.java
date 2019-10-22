package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 88. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 在真实的面试中遇到过这道题？
 * */
public class MergeSortedArray {

    @Test
    public void test(){
        int[] nums1;
        nums1=new int[]{2,0};
        merge(nums1,1,new int[]{1},1);
        Assert.assertArrayEquals(new int[]{1,2},nums1);

        nums1=new int[]{1,2,3,0,0,0};
        int[] nums2=new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        Assert.assertArrayEquals(new int[]{1,2,2,3,5,6},nums1);

        nums1=new int[]{0};
        nums2=new int[]{1};
        merge(nums1,0,nums2,1);
        Assert.assertArrayEquals(new int[]{1},nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if(m==0){
            System.arraycopy(nums2,0,nums1,0,n);
            return;
        }
        int i=m-1;
        int j=n-1;
        int k=n+m-1;
        while (i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        if(j>=0){
            for(k=0;k<=j;k++){
                nums1[k]=nums2[k];
            }
        }

    }
}
