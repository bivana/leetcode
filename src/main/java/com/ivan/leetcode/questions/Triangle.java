package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * */
public class Triangle {

    @Test
    public void test(){
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        list.add(Arrays.asList(new Integer[]{2}));
        list.add(Arrays.asList(new Integer[]{3,4}));
        list.add(Arrays.asList(new Integer[]{6,5,7}));
        list.add(Arrays.asList(new Integer[]{4,1,8,3}));
        Assert.assertEquals(11,minimumTotal3(list));
    }


    /********************递归，自顶向下 【超时】********************************************************/
    public int minimumTotal2(List<List<Integer>> triangle) {
        return helper(0,0, triangle,triangle.size()-1);
    }

    private int helper(int level,int index,List<List<Integer>> triangle,int endRow){
        if(level==endRow){
            return triangle.get(level).get(index);
        }
        int left=helper(level+1,index,triangle,endRow);
        int right=helper(level+1,index+1,triangle,endRow);
        return Math.min(left,right)+triangle.get(level).get(index);
    }

    /********************递归，自顶向下，动态规划 ********************************************************/
    public int minimumTotal3(List<List<Integer>> triangle) {
        Integer[][] memo=new Integer[triangle.size()][triangle.size()];
        return helper(0,0, triangle,triangle.size()-1,memo);
    }

    private int helper(int level,int index,List<List<Integer>> triangle,int endRow,Integer[][] memo){
        if(memo[level][index]!=null){
            return memo[level][index];
        }
        if(level==endRow){
            return triangle.get(level).get(index);
        }
        int left=helper(level+1,index,triangle,endRow);
        int right=helper(level+1,index+1,triangle,endRow);
        int i= Math.min(left,right)+triangle.get(level).get(index);
        memo[level][index]=i;
        return i;
    }

    /********************自底向上, DP 【AC】 ********************************************************/
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

}
