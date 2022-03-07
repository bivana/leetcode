package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2104. 子数组范围和
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 *
 * 返回 nums 中 所有 子数组范围的 和 。
 *
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * 示例 3：
 *
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 * */
public class SumOfSubarrayRanges {

    @Test
    public void test(){
        Assert.assertEquals(4,subArrayRanges(new int[]{1,2,3}));
        Assert.assertEquals(4,subArrayRanges(new int[]{1,3,3}));
        Assert.assertEquals(59,subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
//8 6 4 1 3 9 7
//
//8 6 4 1 1 1 1
//8 8 8 8 8 9 9
    public long subArrayRanges(int[] nums) {
        return 0;
    }
}
