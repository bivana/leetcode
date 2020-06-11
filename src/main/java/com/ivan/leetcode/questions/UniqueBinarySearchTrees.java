package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 通过次数42,861提交次数65,456
 * */
public class UniqueBinarySearchTrees {

    @Test
    public void test(){
        Assert.assertEquals(5,numTrees(3));
    }

    //动态规划 g(n)=g(i-1)*g(n-i)
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int num=2;num<=n;num++){
            for(int i=1;i<=num;i++){
                dp[num]+=dp[i-1]*dp[num-i];
            }
        }
        return dp[n];

    }
}
