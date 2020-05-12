package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * 通过次数15,071提交次数18,359
 * 在真实的面试中遇到过这道题？
 * */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{4,0,1,1,3},smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
        Assert.assertArrayEquals(new int[]{2,1,0,3},smallerNumbersThanCurrent(new int[]{6,5,4,8}));
        Assert.assertArrayEquals(new int[]{0,0,0,0},smallerNumbersThanCurrent(new int[]{7,7,7,7}));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] dp=new int[101];
        for(int i:nums){
            dp[i]++;
        }
        for(int i=1;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[i]=dp[nums[i]-1];
            }

        }
        return nums;
    }
}
