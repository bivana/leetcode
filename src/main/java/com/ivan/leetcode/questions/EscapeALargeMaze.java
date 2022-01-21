package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1036. 逃离大迷宫
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 *
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 * 示例 2：
 *
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 *
 *
 * 提示：
 *
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 * */
public class EscapeALargeMaze {

    @Test
    public void test(){
        Assert.assertEquals(false,isEscapePossible(new int[][]{{691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,612099},{329444,633495},{196657,757958},{628509,883388}},new int[]{655988,180910},new int[]{267728,840949}));


        Assert.assertEquals(false,isEscapePossible(new int[][]{{0,1},{1,0}},new int[]{0,0},new int[]{999999,999999}));
        Assert.assertEquals(true,isEscapePossible(new int[][]{},new int[]{0,0},new int[]{999999,999999}));
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int max0=0;
        int max1=0;
        for(int i=0;i<blocked.length;i++){
            max0=Math.max(max0,blocked[i][0]);
            max1=Math.max(max1,blocked[i][1]);
        }
        boolean[][] dp=new boolean[max0+2][max1+2];
        //转换target
        if(target[0]>max0||target[1]>max1){
            target=new int[]{max0+1,max1+1};
        }
        //将封锁点置为-1
        for(int i=0;i<blocked.length;i++){
            dp[blocked[i][0]][blocked[i][1]]=true;
        }
        int[][] direct=new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> stack=new ArrayDeque<>();
        stack.push(source);
        while (!stack.isEmpty()){
            int[] point=stack.pop();
            if(Arrays.equals(point,target)){
                return true;
            }
            dp[point[0]][point[1]]=true;
            for(int[] d:direct){
                int i=point[0]+d[0];
                int j=point[1]+d[1];
                //超出边界
                if(i<0||j<0||i>=dp.length||j>=dp[0].length){
                    continue;
                }
                //-1或1都表示已经走过了
                if(dp[i][j]==true){
                    continue;
                }
                stack.push(new int[]{i,j});
            }
        }
        return false;
    }
}
