package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 通过次数56,376提交次数165,413
 * */
public class PowxN {

    @Test
    public void test(){
        Assert.assertEquals(0,myPow(2.0,-2147483648),0.000001);
        Assert.assertEquals(1024.0,myPow(2.0,10),0.0);
        Assert.assertEquals(9.261,myPow(2.1,3),0.000001);
        Assert.assertEquals(0.25,myPow(2,-2),0.0);
    }

    /**
     * 暴力法
     * */
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        double rs=1;
        //边界越界处理
        if(n==Integer.MIN_VALUE){
            n=-(n+1);
            rs=x;
        }

        if(n<=3){
            for(int i=1;i<=n;i++){
                rs=rs*x;
            }
        }else{
            if(n%2==0){
                double temp=myPow(x,n/2);
                rs=rs* temp*temp;
            }else{
                rs=rs* myPow(x,n/2)*myPow(x,n/2+1);
            }
        }
        return rs;
    }
}
