package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 *
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * */
public class NumberOfEnclaves {

    @Test
    public void test(){
        Assert.assertEquals(3,numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        Assert.assertEquals(0,numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }

    public int numEnclaves(int[][] grid) {
        boolean[][] dp=new boolean[grid.length][grid[0].length];
        Stack<int[]> stack=new Stack<>();
        int total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){

                    if(i==0||j==0||i==grid.length-1||j==grid[i].length-1||j==0){
                        stack.push(new int[]{i,j});
                        dp[i][j]=true;
                    }else{
                        total++;
                    }
                }
            }
        }
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!stack.isEmpty()){
            int[] point=stack.pop();
            for(int[] direct:directions){
                int[] newPoint=new int[]{point[0]+direct[0],point[1]+direct[1]};
                //超出边界
                if(newPoint[0]<0||newPoint[0]>=grid.length||newPoint[1]<0||newPoint[1]>=grid[0].length){
                    continue;
                }
                if(grid[newPoint[0]][newPoint[1]]==1&&!dp[newPoint[0]][newPoint[1]]){
                    stack.push(newPoint);
                    dp[newPoint[0]][newPoint[1]]=true;
                    total--;
                }
            }
        }
        return total;
    }
}
