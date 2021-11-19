package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * */
public class IntegerReplacement {


    @Test
    public void test(){
        Assert.assertEquals(3,integerReplacement(8));
        Assert.assertEquals(4,integerReplacement(7));
        Assert.assertEquals(2,integerReplacement(4));
    }

    // dp操作，
    // 偶数 dp[i]=dp[i/2]+1
    // 奇数 dp[i]=min(dp[i-1],dp[（i+1）/2]+1)+1
//    public int integerReplacement(int n) {
//        String s=Integer.toBinaryString(n);
//        int len=s.length()-1;
//        111001111
//        111001101
//        return
//        if(n==1){
//            return 0;
//        }
//        if(n%2==0){
//            return integerReplacement(n/2)+1;
//        }else{
//            return Math.min( integerReplacement(n-1),integerReplacement((n+1)/2)+1)+1;
//        }
//
//    }


    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }
//    public int integerReplacement(int n) {
//        Map<Integer,Integer> map=new H
//        dp[1]=0;
//        for(int i=2;i<=n;i++){
//            if(i%2==0){
//                dp[i]=dp[i/2]+1;
//            }else{
//                dp[i]=Math.min(dp[i-1],dp[(i+1)/2]+1)+1;
//            }
//        }
//        return dp[n];

//    }
}
