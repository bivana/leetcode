package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 通过次数46,097提交次数118,518
 * 在真实的面试中遇到过这道题？
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * */
public class ContainsDuplicate2 {

    @Test
    public void test(){
        Assert.assertEquals(false,containsNearbyDuplicate(new int[]{1,2},2));
        Assert.assertEquals(true,containsNearbyDuplicate(new int[]{1,2,3,1},3));
        Assert.assertEquals(true,containsNearbyDuplicate(new int[]{1,0,1,1},1));
        Assert.assertEquals(false,containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length<=1){
            return false;
        }
        Set<Integer> sets=new HashSet<>();
        k=k>=nums.length?nums.length-1:k;
        int start=0;
        int end=k;
        for(int i=start;i<=end;i++){
            if(sets.contains(nums[i])){
                return true;
            }
            sets.add(nums[i]);
        }
        end++;
        while (end<nums.length){
            sets.remove(nums[start]);
            if(sets.contains(nums[end])){
                return true;
            }
            sets.add(nums[end]);
            start++;
            end++;
        }
        return false;
    }
}
