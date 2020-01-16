package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * */
public class IntersectionOfTwoArrays2 {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2,2},intersect(new int[]{1,2,2,1},new int[]{2,2}));
        Assert.assertArrayEquals(new int[]{4,9},intersect(new int[]{4,9,5},new int[]{9,4,9,8,4}));
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null ||nums1.length==0||nums2==null||nums2.length==0){
            return new int[]{};
        }
        int idx1=0;
        int idx2=0;
        int index=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (idx1<nums1.length && idx2<nums2.length){
            if(nums1[idx1]==nums2[idx2]){
                nums1[index++]=nums1[idx1];
                idx1++;
                idx2++;
            }else if(nums1[idx1]>nums2[idx2]){
                idx2++;
            }else{
                idx1++;
            }
        }
        int[] rs=new int[index];
        System.arraycopy(nums1,0,rs,0,index);
        return rs;
    }
}
