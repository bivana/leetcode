package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * */
public class AsFarFromLandAsPossible {

    @Test
    public void test(){
        Assert.assertEquals(2,maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
        Assert.assertEquals(4,maxDistance(new int[][]{{1,0,0},{0,0,0},{0,0,0}}));
    }

    public int maxDistance(int[][] grid) {
        int max=0;
        Queue<int[]> stack=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    stack.offer(new int[]{i,j});
                }
            }
        }
        int[] rd=new int[]{0,0,1,-1};
        int[] cd=new int[]{1,-1,0,0};
        int[] point=null;
        boolean haOchena=false;
        while (!stack.isEmpty()){
            point=stack.poll();
            for(int k=0;k<rd.length;k++){
                int newI=point[0]+rd[k];
                int newJ=point[1]+cd[k];
                if(newI<0||newI>=grid.length||newJ<0||newJ>=grid.length||grid[newI][newJ]!=0){
                    continue;
                }
                haOchena=true;
                grid[newI][newJ]=grid[point[0]][point[1]]+1;
                stack.offer(new int[]{newI,newJ});
            }
        }
        if(point==null||!haOchena){
            return -1;
        }
        return grid[point[0]][point[1]]-1;

    }


}
