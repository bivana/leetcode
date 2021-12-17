package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 *
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 * */
public class ColoringABorder {

    @Test
    public void test(){
        ShowUtil.showIntMatrix(colorBorder(new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}},0,1,1));
        ShowUtil.showIntMatrix(colorBorder(new int[][]{{1,1},{1,2}},0,0,3));
        ShowUtil.showIntMatrix(colorBorder(new int[][]{{1,2,2},{2,3,2}},0,1,3));
        ShowUtil.showIntMatrix(colorBorder(new int[][]{{1,1,1},{1,1,1},{1,1,1}},1,1,2));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Integer[]> queue=new ArrayDeque<>();
        Queue<Integer[]> targetQueue=new ArrayDeque<>();//待转换的目标
        int target=grid[row][col];
        queue.add(new Integer[]{row,col});
        int[][] directions=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        boolean[][] dp=new boolean[grid.length][grid[0].length];
        int xLimit=grid.length-1;
        int yLimit=grid[0].length-1;
        while (!queue.isEmpty()){
            Integer[] pos=queue.poll();
            if(grid[pos[0]][pos[1]]==target){
                dp[pos[0]][pos[1]]=true;//标记为已检索
                for(int[] direct:directions){
                    int x=pos[0]+direct[0];
                    int y=pos[1]+direct[1];
                    //边界内放入
                    if(x>=0&&x<=xLimit&&y>=0 && y<=yLimit){
                        //在边界，或者边界不为目标值，说明此处为边界，那么变色
                        if(pos[0]==0||pos[1]==0||pos[0]==xLimit||pos[1]==yLimit||grid[x][y]!=target){
                            targetQueue.add(pos);//放入待转换队列
                        }
                        //将未检索的放入队列中，继续广度
                        if(!dp[x][y]){
                            queue.add(new Integer[]{x,y});
                        }
                    }

                }
            }
        }
        while (!targetQueue.isEmpty()){
            Integer[] pos=targetQueue.poll();
            grid[pos[0]][pos[1]]=color;
        }
        return grid;
    }
}
