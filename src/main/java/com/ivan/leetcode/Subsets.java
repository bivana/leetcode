package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * */
public class Subsets {

    @Test
    public void test(){
        List<List<Integer>> list=subsets(new int[]{1,2,3});
        for(List<Integer> l:list){
            System.out.println(l.toString());
        }
    }




    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        if (len == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<Integer>();
        subsets(nums, 0, pre,res);
        return res;
    }

    private void subsets(int[] nums,int pos,List<Integer> temp,List<List<Integer>> res){
        res.add(new ArrayList<Integer>(temp));
        for(int i=pos;i<nums.length;i++){
            temp.add(nums[i]);
            subsets(nums,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
