package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 通过次数27,032提交次数42,073
 * */
public class SurfaceAreaOf3dShapes {

    @Test
    public void test(){
        Assert.assertEquals(16,surfaceArea(new int[][]{{1,0},{0,2}}));
        Assert.assertEquals(10,surfaceArea(new int[][]{{2}}));
        Assert.assertEquals(34,surfaceArea(new int[][]{{1,2},{3,4}}));
        Assert.assertEquals(32,surfaceArea(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        Assert.assertEquals(46,surfaceArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}}));
    }

    public int surfaceArea(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int[][] direction=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    continue;
                }
                total+=4*grid[i][j]+2;
                for(int a=0;a<direction.length;a++){
                    int x=i+direction[a][0];
                    int y=j+direction[a][1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[i].length && grid[x][y]!=0){
                        total-=Math.min(grid[i][j],grid[x][y]);
                    }
                }
            }
        }
        return total;
    }
}
