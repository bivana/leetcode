package com.ivan.leetcode.jzof;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 * */
public class B1IidL {

    @Test
    public void test(){
        Assert.assertEquals(2,peakIndexInMountainArray(new int[]{1,3,5,4,2}));
        Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,10,5,2}));
        Assert.assertEquals(2,peakIndexInMountainArray(new int[]{3,4,5,1}));
        Assert.assertEquals(2,peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
        Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,1,0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int l=1;
        int r=arr.length-2;
        while (l<r){
            int mid=(l+r)>>1;
            if(arr[mid]<arr[mid+1]){//左边比比较点大，那么山峰在左边
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }

//    public int peakIndexInMountainArray(int[] arr) {
//        int l=0;
//        int r=arr.length-1;
//        while (l<r){
//            int mid=(l+r)>>1;
//            if(arr[mid]<arr[mid-1]){//左边比比较点大，那么山峰在左边
//                r=mid;
//            }else if(arr[mid]<arr[mid+1]){//比较点比右边大，那边山峰在右边
//                l=mid;
//            }else{
//                l=mid;
//                r=mid;
//            }
//        }
//        return l;
//    }
}
