package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 在真实的面试中遇到过这道题？
 * */
public class ClimbingStairs {

    @Test
    public void test(){
        Assert.assertEquals(2,climbStairs(2));
        Assert.assertEquals(3,climbStairs(3));
        System.out.println(climbStairs(7));
    }

    Integer[] dp;

    public int climbStairs(int n) {
        dp=new Integer[n];
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int step=subClimb(n-1)+subClimb(n-2);
        return step;
    }

    private int subClimb(int n){
        if(dp[n]!=null){
            return dp[n];
        }
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        int step=subClimb(n-1)+subClimb(n-2);
        dp[n]=step;
        return step;
    }
}
