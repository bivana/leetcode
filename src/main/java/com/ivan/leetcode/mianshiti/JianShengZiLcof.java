package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 通过次数20,197提交次数37,272
 * */
public class JianShengZiLcof {

    @Test
    public void test(){
        Assert.assertEquals(18,cuttingRope(8));
        Assert.assertEquals(1,cuttingRope(2));
        Assert.assertEquals(36,cuttingRope(10));
    }

    /**
     * dp 动态规划
     * */
    public int cuttingRope(int n) {
        if(n==1){
            return 1;
        }
        int[] dp=new int[n];
        //可以包含自己的
        for(int i=1;i<n;i++){
            int max=i;
            for(int j=1;j<i;j++){
                max=Math.max(max,dp[j]*dp[i-j]);
            }
            dp[i]=max;
        }
        int max=0;
        for(int m=1;m<n;m++){
            max=Math.max(max,dp[m]*dp[n-m]);
        }
        return max;
    }



//    /**
//     * 暴力法
//     * */
//    public int cuttingRope(int n) {
//        if(n==1){
//            return 1;
//        }
//        int max=0;
//        for(int m=1;m<n;m++){
//            int sum=cuttingRope2(m)*cuttingRope2(n-m);
//            if(sum>max){
//                System.out.println(">>>>>>>");
//                System.out.println("max:"+max);
//                System.out.println(sum);
//                System.out.println(cuttingRope2(m));
//                System.out.println(cuttingRope2(n-m));
//            }
//            max=Math.max(max,cuttingRope2(m)*cuttingRope2(n-m));
//        }
//        return max;
//    }
//
//    public int cuttingRope2(int n) {
//        if(n==1){
//            return 1;
//        }
//        int max=n;
//        for(int m=1;m<n;m++){
//            max=Math.max(max,cuttingRope2(m)*cuttingRope2(n-m));
//        }
//        return max;
//    }
}
