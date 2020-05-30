package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 通过次数42,779提交次数74,604
 * */
public class Permutations2 {

    @Test
    public void test(){
//        List<List<Integer>> list=permuteUnique(new int[]{1,1,2});
//        ShowUtil.showListMatrix(list);

        List<List<Integer>> list=permuteUnique(new int[]{2,2,1,1});
        ShowUtil.showListMatrix(list);

//        List<List<Integer>> list=permuteUnique(new int[]{-1,2,0,-1,1,0,1});
//        ShowUtil.showListMatrix(list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs=new ArrayList<>();
        backtrace(nums,0,rs);
        return rs;
    }

    private void backtrace(int[] nums,int first,List<List<Integer>> rs){
        if(first==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            rs.add(temp);
        }
        Set<Integer> swaped=new HashSet<>();
        for(int i=first;i<nums.length;i++){

            if(swaped.contains(nums[i])){
                continue;
            }
            swaped.add(nums[i]);
            swap(nums,first,i);
            backtrace(nums,first+1,rs);
            swap(nums,first,i);
        }
    }

//    private void backtrace(int[] nums,int first,List<List<Integer>> rs){
//        if(first==nums.length){
//            List<Integer> temp=new ArrayList<>();
//            for(int i:nums){
//                temp.add(i);
//            }
//            rs.add(temp);
//        }
//        for(int i=first;i<nums.length;i++){
//            if(nums[i]==nums[first] && first!=i){
//                continue;
//            }
//            //和之前的交换一样，不进行交换
//            if(i>first && nums[i]==nums[i-1]){
//                continue;
//            }
//            swap(nums,first,i);
//            backtrace(nums,first+1,rs);
//            swap(nums,first,i);
//        }
//    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
