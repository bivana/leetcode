package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 * */
public class QingWaTiaoTaiJieWenTiLcof {

    @Test
    public void test(){
        Assert.assertEquals(2,numWays(2));
        Assert.assertEquals(21,numWays(7));
    }

    //f(n)=f(n-1)+f(n-2)  f(1)=1 f(2=2)
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        if(n<=2){
            return n;
        }
        int last=1;
        int step=2;
        for(int i=3;i<=n;i++){
            int temp=(step+last)%1000000007;
            last=step;
            step=temp;
        }
        return step;

    }
}
