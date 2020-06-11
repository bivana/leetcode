package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * */
public class UniquePaths2 {

    @Test
    public void test(){
//        Assert.assertEquals(2,uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        Assert.assertEquals(0,uniquePathsWithObstacles2(new int[][]{{1}}));
    }

    /**
     * 递归解，动态规划***********************************************************************
     * */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        Integer[][] memo=new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return helper2(obstacleGrid,0,0,memo);
    }

    private int helper2(int[][] obstacleGrid,int i,int j,Integer[][] memo){

        if(i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j]==1){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
            return 1;
        }

        int count= helper2(obstacleGrid,i+1,j,memo)+helper2(obstacleGrid,i,j+1,memo);
        memo[i][j]=count;
        return count;
    }

    /**
     * 递归解***********************************************************************
     * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        return helper(obstacleGrid,0,0);
    }

    private int helper(int[][] obstacleGrid,int i,int j){
        if(i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
            return 1;
        }

        return helper(obstacleGrid,i+1,j)+helper(obstacleGrid,i,j+1);
    }
}
