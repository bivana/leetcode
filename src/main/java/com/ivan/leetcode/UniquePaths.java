package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * 在真实的面试中遇到过这道题？
 * */
public class UniquePaths {

    @Test
    public void test(){
        System.out.println(uniquePaths(1,1));
        Assert.assertEquals(1,uniquePaths(1,1));
        Assert.assertEquals(3,uniquePaths(3,2));
        Assert.assertEquals(28,uniquePaths(7,3));
    }

    /**
     * 动态规划 利用杨辉三角  当前数等于前面两个数之和
     * */
    public int uniquePaths(int m, int n) {
        Integer[] nums=new Integer[n];
        Arrays.fill(nums,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                nums[j]=nums[j-1]+nums[j];
            }
        }
        return nums[n-1];
    }

    /**
     * 动态规划
     * */
    public int uniquePaths2(int m, int n) {
        Integer[][] nums=new Integer[m][n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(i==0 && j==0){
                    nums[i][j]=1;
                }else if(i==0 ){
                    nums[i][j]=1;
                }else if(j==0 ){
                    nums[i][j]=1;
                }else{
                    nums[i][j]=nums[i-1][j]+nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }
}
