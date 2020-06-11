package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 通过次数61,457提交次数94,780
 * */
public class FindTheDuplicateNumber {

    @Test
    public void test(){
        Assert.assertEquals(4,findDuplicate(new int[]{4,3,1,4,2}));

        Assert.assertEquals(2,findDuplicate(new int[]{1,3,4,2,2}));
        Assert.assertEquals(3,findDuplicate(new int[]{3,1,3,4,2}));
    }

    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        while (nums[slow]!=nums[nums[fast]]){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int findor=0;
        slow=nums[slow];
        while (nums[findor]!=nums[slow]){
            slow=nums[slow];
            findor=nums[findor];
        }
        return nums[slow];
    }
}
