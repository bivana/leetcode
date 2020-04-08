package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 * 通过次数24,881提交次数49,022
 * */
public class RottingOranges {

    @Test
    public void test(){
        Assert.assertEquals(4,orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        Assert.assertEquals(-1,orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        Assert.assertEquals(0,orangesRotting(new int[][]{{0,2}}));

    }

    int[] dr={-1,0,0,1};
    int[] dc={0,-1,1,0};

    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int rSize=grid.length;
        int cSize=grid[0].length;
        int ans=0;
        Queue<Integer> queue=new ArrayDeque<>();
        int[] rotting=new int[grid.length*grid[0].length];
        for(int i=0;i<rSize;i++){
            for(int j=0;j<cSize;j++){
                int num=i*cSize+j;
                if(grid[i][j]==2){
                    queue.add(num);
                }
            }
        }
        while (!queue.isEmpty()){
            int num=queue.poll();
            int i=num/cSize;
            int j=num%cSize;
            for(int k=0;k<dr.length;k++){
                int row=i+dr[k];
                int col=j+dc[k];
                if(row>=0 && row<rSize && col>=0 && col<cSize && grid[row][col]==1){
                    grid[row][col]=2;
                    int code=row*cSize+col;
                    rotting[code]=rotting[num]+1;
                    ans=rotting[code];
                    queue.add(code);
                }
            }
        }
        for(int i=0;i<rSize;i++){
            for(int j=0;j<cSize;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;

    }
}
