package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 * 通过次数36,990提交次数69,805
 * */
public class MaximizeSumOfArrayAfterKNegations {

    @Test
    public void test(){
        Assert.assertEquals(13,largestSumAfterKNegations(new int[]{2,-3,-1,5,-4},2));
        Assert.assertEquals(22,largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2},6));
        Assert.assertEquals(5,largestSumAfterKNegations(new int[]{-4,-2,-3},4));
        Assert.assertEquals(5,largestSumAfterKNegations(new int[]{4,2,3},1));
        Assert.assertEquals(6,largestSumAfterKNegations(new int[]{3,-1,0,2},3));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int minAbs=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            minAbs=Math.min(Math.abs(nums[i]),minAbs);
            if(nums[i]<0&&k>0){
                ans=ans-nums[i];
                k--;
            }else{
                ans=ans+nums[i];
            }
        }
        if(k%2==1){
            ans=ans-2*minAbs;
        }
        return ans;
    }

//    public int largestSumAfterKNegations(int[] nums, int k) {
//        Arrays.sort(nums);
//        int ans=0;
//        int last=0;
//        for(int i=0;i<nums.length;i++){
//            if(k>0){
//                if(nums[i]<0){
//                    ans=ans-nums[i];
//                    k--;
//                }else if(nums[i]>=0){
//                    if(last<0&&k%2==1){//偶数，加上最小的
//                        if(nums[i]>-last){
//                            ans=ans+nums[i]+2*last;
//                        }else{
//                            ans=ans-nums[i];
//                        }
//                    }else{
//                        ans=ans+nums[i];
//                    }
//                }
//            }else{
//                ans=ans+nums[i];
//            }
//            last=nums[i];
//        }
//        if(nums[0]>0){
//            ans=ans-2*nums[0];
//        }
//        if(nums[nums.length-1]<0&&k%2==1){
//            ans=ans+2*nums[nums.length-1];
//        }
//        return ans;
//    }
}
