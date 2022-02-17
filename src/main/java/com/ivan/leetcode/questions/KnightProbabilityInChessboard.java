package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * 688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 *
 *
 * 提示:
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 * */
public class KnightProbabilityInChessboard {

    @Test
    public void test(){
//        // 期望 2.35*E23
        Assert.assertEquals(0.00019,knightProbability(8,30,0,0),0.00001);
        Assert.assertEquals(0.0625,knightProbability(3,2,0,0),0.001);
        Assert.assertEquals(1.00000,knightProbability(1,0,0,0),0.001);
    }

    public double knightProbability(int n, int k, int row, int column) {
        if(k==0){
            return 1;
        }
        Double[][][] dp=new Double[n][n][k+1];//i,j,s 表示当点位在i,j 时，还剩k步的情况下能获取到个数
        Double total=Math.pow(8,k);
        Stack<int[]> stack=new Stack();
        stack.push(new int[]{row,column,k});
        int[][] directions=new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        while (!stack.isEmpty()){
            int[] point=stack.peek();
            if(dp[point[0]][point[1]][point[2]]!=null){
                stack.pop();
            }else if(point[2]==0){
                dp[point[0]][point[1]][point[2]]=1.0;
                stack.pop();
            }else{
                boolean isFinished=true;
                Double sum=0.0;
                for(int[] direct:directions){
                    int cnt=point[2]-1;
                    int[] nextPoint=new int[]{point[0]+direct[0],point[1]+direct[1],cnt};
                    //越界
                    if(nextPoint[0]<0||nextPoint[0]>=n||nextPoint[1]<0||nextPoint[1]>=n){
                        continue;
                    }
                    if(dp[nextPoint[0]][nextPoint[1]][nextPoint[2]]==null){
                        stack.push(nextPoint);
                        isFinished=false;
                    }else{
                        sum+=dp[nextPoint[0]][nextPoint[1]][nextPoint[2]];
                    }
                }
                if(isFinished){
                    dp[point[0]][point[1]][point[2]]=sum;
                    stack.pop();
                }
            }
        }
//        System.out.println(dp[row][column][k]);
//        System.out.println(total);
        double ans=  dp[row][column][k]/total;
        return ans;
    }



}
