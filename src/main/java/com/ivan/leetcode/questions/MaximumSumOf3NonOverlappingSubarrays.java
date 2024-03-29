package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 689. 三个无重叠子数组的最大和
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 *
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * */
public class MaximumSumOf3NonOverlappingSubarrays {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{0,3,5},maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2));
        Assert.assertArrayEquals(new int[]{0,2,4},maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1},2));
    }

    //暴力，
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        return null;
    }
}
