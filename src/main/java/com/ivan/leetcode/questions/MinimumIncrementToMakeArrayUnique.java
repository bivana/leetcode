package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 * 通过次数26,879提交次数56,402
 * */
public class MinimumIncrementToMakeArrayUnique {

    @Test
    public void test(){
        Assert.assertEquals(1,minIncrementForUnique(new int[]{1,2,2}));
        Assert.assertEquals(6,minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    /**缩短路径法*/
    public int minIncrementForUnique(int[] A) {
        if(A==null||A.length<=1){
            return 0;
        }
        int[] memo=new int[80000];
        Arrays.fill(memo,-1);
        int add=0;
        for(int i:A){
            int pos=findPos(memo,i);
            add+=pos-i;
        }
        return add;
    }

    public int findPos(int[] memo,int i){
        if (memo[i]==-1){
            memo[i]=i;
            return i;
        }
        int j=findPos(memo,memo[i]++);
        memo[i]=j;
        return j;
    }

    /**计数算法*/
    public int minIncrementForUnique3(int[] A) {
        if(A==null||A.length<=1){
            return 0;
        }
        int[] memo=new int[40000];
        for(int i:A){
            memo[i]+=1;
        }
        int add=0;
        for(int i=0;i<memo.length-1;i++){
            if(memo[i]>1){
                add+=memo[i]-1;
                memo[i+1]+=memo[i]-1;
            }
        }
        if(memo[memo.length-1]>1){
            int val=memo[memo.length-1]-1;
            add+=(1+val)*val/2;
        }
        return add;
    }

    /**排序*/
    public int minIncrementForUnique2(int[] A) {
        if(A==null||A.length<=1){
            return 0;
        }
        Arrays.sort(A);
        int add=0;
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                add+=A[i-1]+1-A[i];
                A[i]=A[i-1]+1;
            }
        }
        return add;
    }
}
