package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 46. 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * */
public class Permutations {

    @Test
    public void test(){
        List<List<Integer>> list=permute(new int[]{1,2,3});
        for(List<Integer> list1:list){
            for(Integer i:list1){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        backTrace(nums,0,list);
        return list;
    }

    private void backTrace(int[] nums,int first,List<List<Integer>> res){
        if(first==nums.length){
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int i:nums){
                l.add(i);
            }
            res.add(l);
        }
        for(int i=first;i<nums.length;i++){
            swap(nums,first,i);
            backTrace(nums,first+1,res);
            swap(nums,first,i);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }




//    public List<List<Integer>> permute(int[] nums) {
//        // init output list
//        List<List<Integer>> output = new LinkedList<List<Integer>>();
//
//        // convert nums into list since the output is a list of lists
//        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
//        for (int num : nums)
//            nums_lst.add(num);
//
//        int n = nums.length;
//        backtrack(n, nums_lst, output, 0);
//        return output;
//    }
//
//    public void backtrack(int n,
//                          ArrayList<Integer> nums,
//                          List<List<Integer>> output,
//                          int first) {
//        // if all integers are used up
//        if (first == n)
//            output.add(new ArrayList<Integer>(nums));
//        for (int i = first; i < n; i++) {
//            // place i-th integer first
//            // in the current permutation
//            Collections.swap(nums, first, i);
//            // use next integers to complete the permutations
//            backtrack(n, nums, output, first + 1);
//            // backtrack
//            Collections.swap(nums, first, i);
//        }
//    }

    // curSize 表示当前的路径 path 里面有多少个元素

    private void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }
}
