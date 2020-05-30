package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * */
public class IntersectionOfTwoArrays {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2},intersection(new int[]{1,2,2,1},new int[]{2,2}));
        Assert.assertArrayEquals(new int[]{9,4},intersection(new int[]{4,9,5},new int[]{9,4,9,8,4}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0){
            return new int[]{};
        }
        Set<Integer> sets=new HashSet<>();
        for(int i:nums1){
            sets.add(i);
        }
        int[] rs=new int[sets.size()];
        int index=0;
        for(int i:nums2){
            if(sets.contains(i)){
                rs[index++]=i;
                sets.remove(i);
            }
        }
        int[] fs=new int[index];
        System.arraycopy(rs,0,fs,0,index);
        return fs;
    }
}
