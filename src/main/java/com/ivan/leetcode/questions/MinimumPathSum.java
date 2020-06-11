package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * */
public class MinimumPathSum {

    @Test
    public void test(){
//        Assert.assertEquals(7,minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        minPathSum(new int[][]{{1,2,5},{3,2,1}});
    }

    //一维 动态规划 dp(j)=grid(i,j)+min(dp(j),dp(j+1))
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    //二维 动态规划 P(i,j)=grid(i,j)+min(P(i+1,j),P(i,j+1))
    public int minPathSum4(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[][] p=new int[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j==grid[0].length-1){
                    p[i][j]=grid[i][j];
                }else if(i==grid.length-1){
                    p[i][j]=grid[i][j]+p[i][j+1];
                }else if(j==grid[0].length-1){
                    p[i][j]=grid[i][j]+p[i+1][j];
                }else{
                    p[i][j]=grid[i][j]+Math.min(p[i+1][j],p[i][j+1]);
                }

            }
        }
        return p[0][0];
    }

    //暴力破解法  采用动态规划查询
    public int minPathSum3(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int min=minPathSum3(grid,0,0);
        return min;
    }

    public int minPathSum3(int[][] grid,int i,int j){
        if(i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j]+Math.min(minPathSum3(grid,i+1,j),minPathSum3(grid,i,j+1));
    }

    //暴力破解法  采用动态规划查询
    public int minPathSum2(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        List<Integer> sumList=new ArrayList<Integer>();
        minPath2(grid,sumList,0,0,0);
        Integer a=Collections.min(sumList);
        return a;
    }

    public void minPath2(int[][] grid,List<Integer> sumList,int i,int j,int sum){
        sum=sum+grid[i][j];
        if(i<grid.length-1){
            minPath2(grid,sumList,i+1,j,sum);
        }
        if(j<grid[0].length-1){
            minPath2(grid,sumList,i,j+1,sum);
        }
        //到头了
        if(i==grid.length-1 && j==grid[0].length-1){
            sumList.add(sum);
        }

    }
}
