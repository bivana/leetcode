package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 通过次数30,594提交次数63,514
 * */
public class JiQiRenDeYunDongFanWeiLcof {

    @Test
    public void test(){
        Assert.assertEquals(3,movingCount(2,3,1));
        Assert.assertEquals(1,movingCount(3,1,0));
    }

    int[] rd=new int[]{0,1,0,-1};

    int[] cd=new int[]{-1,0,1,0};

    public int movingCount(int m, int n, int k) {
        count=0;
        int[][] dp=new int[m][n];
        movingCount(dp,0,0,k);
        return count;
    }

    int count=0;

    public void movingCount(int[][] dp,int i,int j,int target){
        if(i>=0 && i<dp.length && j>=0 && j<dp[0].length && dp[i][j]==0){
            if(getDistince(i)+getDistince(j)<=target){
                dp[i][j]=1;
                count++;
                for(int k=0;k<4;k++){
                    movingCount(dp,i+rd[k],j+cd[k],target);
                }
            }else{
                dp[i][j]=-1;
            }
        }

    }

    public int getDistince(int i){
        int distince=0;
        while (i>0){
            distince+=(i%10);
            i=i/10;
        }
        return distince;
    }
}
