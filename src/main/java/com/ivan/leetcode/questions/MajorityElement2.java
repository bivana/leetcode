package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * */
public class MajorityElement2 {

    @Test
    public void test(){
        Assert.assertArrayEquals(new Integer[]{3},majorityElement(new int[]{3,2,3}).toArray());
        Assert.assertArrayEquals(new Integer[]{1},majorityElement(new int[]{1}).toArray());
        Assert.assertArrayEquals(new Integer[]{1,2},majorityElement(new int[]{1,1,1,3,3,2,2,2}).toArray());
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int three=nums.length/3;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>three){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
