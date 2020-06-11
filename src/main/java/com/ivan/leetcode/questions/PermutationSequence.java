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
//        Assert.assertEquals("213",getPermutation(3,3));
        Assert.assertEquals("2314",getPermutation(4,9));
    }

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, getN(n - 1), k, visited);
    }

    /**
     * 先确定第一位
     * @param n 剩余的数字个数，递减
     * @param f 每组的排列个数
     */
    private String recursive(int n, int f, int k, boolean[]visited){
        int offset = k%f;// 组内偏移量
        int groupIndex = (k-1)/f +1;// 第几组
        // 在没有被访问的数字里找第 groupIndex 个数字
        int i = 0;
        for(; i < visited.length && groupIndex > 0; i++){
            if(!visited[i]){
                groupIndex--;
            }
        }
        visited[i-1] = true;// 标记为已访问
        if(n - 1 > 0){
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n-1, f/(n - 1), offset == 0 ? f : offset, visited);
        }else{
            // 最后一数字
            return String.valueOf(i);
        }
    }

    public int getN(int n){
        int rs=1;
        for(int i=2;i<=n;i++){
            rs=rs*i;
        }
        return rs;
    }
}
