package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * */
public class CoinChange {

    @Test
    public void test(){
        Assert.assertEquals(20,coinChange(new int[]{186,419,83,408},6249));
        Assert.assertEquals(2,coinChange(new int[]{1},2));
        Assert.assertEquals(3,coinChange(new int[]{1,2,5},11));
        Assert.assertEquals(-1,coinChange(new int[]{2},3));
    }

    //自底向上
    public int coinChange(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);

        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }

    //动态规划
    public int coinChange2(int[] coins, int amount) {
        Map<Integer,Integer> dp=new HashMap<>();
        Arrays.sort(coins);
        return coinChange(coins,amount,dp);
    }

    public int coinChange(int[] coins,int amount,Map<Integer,Integer> dp){
        if(dp.get(amount)!=null){
            return dp.get(amount);
        }
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }

        int min=Integer.MAX_VALUE;
        for(int j=coins.length-1;j>=0;j--){
            int step=coinChange(coins,amount-coins[j],dp)+1;
            if(step>0 && step<min){
                min=step;
            }
        }
        if(min!=Integer.MAX_VALUE){
            dp.put(amount,min);
            return min;
        }else{
            dp.put(amount,-1);
            return -1;
        }
    }
}
