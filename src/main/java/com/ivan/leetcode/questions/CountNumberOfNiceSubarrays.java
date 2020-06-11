package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * */
public class CountNumberOfNiceSubarrays {

    @Test
    public void test(){
        Assert.assertEquals(16,numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));
        Assert.assertEquals(2,numberOfSubarrays(new int[]{1,1,2,1,1},3));
        Assert.assertEquals(0,numberOfSubarrays(new int[]{2,4,6},1));

    }

    public int numberOfSubarrays2(int[] nums, int k) {
        if(nums==null||nums.length<k){
            return 0;
        }
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                list.add(i);
            }
        }
        list.add(nums.length);
        if(list.size()<k+2){
            return 0;
        }
        int sum=0;
        int start=1;
        int end=k;
        while (end<list.size()-1){
            sum+=(list.get(start)-list.get(start-1))*(list.get(end+1)-list.get(end));
            end++;
            start++;
        }
        return sum;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
}
