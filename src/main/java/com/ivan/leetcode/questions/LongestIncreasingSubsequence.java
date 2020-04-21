package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 通过次数88,651提交次数200,709
 * */
public class LongestIncreasingSubsequence {

    @Test
    public void test(){
        Assert.assertEquals(6,lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        Assert.assertEquals(4,lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] top=new int[nums.length];
        int piles=0;
        for(int num:nums){
            int left=0;
            int right=piles;
            while(left<right){
                int mid=(left+right)>>>1;
                if(top[mid]>num){
                    right=mid;
                }else if(top[mid]<num){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            if(left==piles){
                piles++;
            }
            top[left]=num;
        }
        return piles;
    }



//    public int lengthOfLIS(int[] nums) {
//        int[] top = new int[nums.length];
//        // 牌堆数初始化为 0
//        int piles = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // 要处理的扑克牌
//            int poker = nums[i];
//
//            /***** 搜索左侧边界的二分查找 *****/
//            int left = 0, right = piles;
//            while (left < right) {
//                int mid = (left + right) / 2;
//                if (top[mid] > poker) {
//                    right = mid;
//                } else if (top[mid] < poker) {
//                    left = mid + 1;
//                } else {
//                    right = mid;
//                }
//            }
//            /*********************************/
//
//            // 没找到合适的牌堆，新建一堆
//            if (left == piles) piles++;
//            // 把这张牌放到牌堆顶
//            top[left] = poker;
//        }
//        // 牌堆数就是 LIS 长度
//        return piles;
//    }
//
//
//    public int lengthOfLIS(int[] nums) {
//        if(nums==null||nums.length==0){
//            return 0;
//        }
//        if(nums.length==1){
//            return 1;
//        }
//        int max=0;
//        int[] memo=new int[nums.length];
//        Arrays.fill(memo,1);
//        for(int i=1;i<nums.length;i++){
//            for(int j=i-1;j>=0;j--){
//                if(nums[i]>nums[j]){
//                    memo[i]=Math.max(memo[j]+1,memo[i]);
//                }
//            }
//            if(memo[i]>max){
//                max=memo[i];
//            }
//        }
//        return max;
//    }
}
