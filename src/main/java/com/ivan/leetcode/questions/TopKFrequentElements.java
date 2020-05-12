package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 通过次数53,235提交次数87,499
 * */
public class TopKFrequentElements {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2,1},topKFrequent(new int[]{1,1,1,2,2,3},2));
        Assert.assertArrayEquals(new int[]{1},topKFrequent(new int[]{1},1));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for(Integer key:map.keySet()){
            priorityQueue.add(key);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        int[] ans=new int[k];
        int i=0;
        while (!priorityQueue.isEmpty()){
            ans[i++]=priorityQueue.poll();
        }
        return ans;
    }


}
