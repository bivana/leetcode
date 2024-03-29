package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 * */
public class LongestArithmeticSubsequenceOfGivenDifference {

    @Test
    public void test(){
        Assert.assertEquals(4,longestSubsequence(new int[]{1,2,3,4},1));
        Assert.assertEquals(1,longestSubsequence(new int[]{1,3,5,7},1));
        Assert.assertEquals(4,longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }

    /**
     * 动态规划，超时
     * map[key] 表示前面最长的等差数列
     * */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=1;
        for(int i=0;i<arr.length;i++){
            int target=arr[i]-difference;
            if(map.containsKey(target)){
                int newCnt=map.get(target)+1;
                if(newCnt>map.getOrDefault(arr[i],0)){
                    map.put(arr[i],newCnt);
                    ans=Math.max(ans,newCnt);
                }
            }else{
                map.put(arr[i],1);
            }
        }
        return ans;

    }

    @Test
    public void test2(){
        System.out.println(longestSubsequence(new int[]{1,2,3,-1,0,1,2,3,4},1));
    }

    public int longestSubsequence2(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

}
