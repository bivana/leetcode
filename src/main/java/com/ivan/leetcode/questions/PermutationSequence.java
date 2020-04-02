package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 通过次数25,961提交次数53,542
 * */
public class PermutationSequence {

    @Test
    public void test(){
        Assert.assertEquals("213",getPermutation(3,3));
        Assert.assertEquals("2314",getPermutation(4,9));
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int total=getN(n);
        for(int i=n;i>=1;i--){
            if((total=total/i)<k){
                sb.append(i-1);
            }
        }
        return null;
    }

    public int getN(int n){
        int rs=1;
        for(int i=2;i<=n;i++){
            rs=rs*i;
        }
        return rs;
    }
}
