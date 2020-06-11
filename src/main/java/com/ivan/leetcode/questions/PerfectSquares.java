package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 通过次数57,486提交次数102,723
 * */
public class PerfectSquares {

    @Test
    public void test(){
        Assert.assertEquals(3,numSquares(12));
        Assert.assertEquals(2,numSquares(13));
    }

    //dp[i]=min(dp[i] dp[i]-j*j+1)
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;
            int pow=0;
            for(int j=2;(pow=j*j)<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-pow]+1);
            }
        }
        return dp[n];
    }
}
