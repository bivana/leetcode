package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * */
public class CombinationSum {

    @Test
    public void test(){
        List<List<Integer>> list=combinationSum(new int[]{4,2,8},8);
        ShowUtil.showListMatrix(list);

        System.out.println("------");
//
//        List<List<Integer>> list=combinationSum(new int[]{2,3,6,7},7);
//        ShowUtil.showListMatrix(list);
//
//        System.out.println("------");
//
//        ShowUtil.showListMatrix(combinationSum(new int[]{2,3,5},8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        find(rs,candidates,0,target,new ArrayList<Integer>(),0);
        return rs;
    }

    public void find(List<List<Integer>> rs,int[] candidates,int start,int target,List<Integer> temp,int sum){
        for(int i=start;i<candidates.length;i++){
            List<Integer> list=new LinkedList<>(temp);
            sum=sum+candidates[i];
            if(sum==target){
                list.add(candidates[i]);
                rs.add(list);
                break;
//                sum=sum-candidates[i];
//                continue;
            }else if(sum<target){
                list.add(candidates[i]);
                find(rs,candidates,i,target,list,sum);
                sum=sum-candidates[i];
            }else{
                sum=sum-candidates[i];
                continue;
            }
        }
    }
}
