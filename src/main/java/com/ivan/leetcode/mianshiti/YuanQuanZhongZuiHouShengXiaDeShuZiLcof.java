package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * 通过次数26,874提交次数44,272
 * */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

    @Test
    public void test(){
        Assert.assertEquals(3,lastRemaining(5,3));
        Assert.assertEquals(2,lastRemaining(10,17));
    }

    /**
     * 数学解法
     * */
    public int lastRemaining(int n, int m) {
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=(ans+m)%i;
        }
        return ans;
    }

    public int lastRemaining2(int n, int m) {
        int[] cycle=new int[n];
        for(int i=0;i<n;i++){
            cycle[i]=i;
        }
        int start=0;
        int end=cycle.length-1;
        int delete=0;
        while (start!=end){
            delete=(delete+m-1)%(end-start+1);

            for(int i=delete+1;i<=end;i++){
                cycle[i-1]=cycle[i];
            }
            end--;
        }
        return cycle[0];

    }
}
