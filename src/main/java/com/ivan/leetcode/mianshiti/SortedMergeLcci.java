package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 * */
public class SortedMergeLcci {

    @Test
    public void test(){
        int[] array1=new int[]{1,2,3,0,0,0};
        int[] array2=new int[]{2,5,6};
        merge(array1,3,array2,3);
        Assert.assertArrayEquals(new int[]{1,2,2,3,5,6},array1);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int index=m+n-1;
        int i=m-1;
        int j=n-1;
        while (i>=0 && j>=0){
            if(A[i]>=B[j]){
                A[index--]=A[i--];
            }else{
                A[index--]=B[j--];
            }
        }
        while (j>=0){
            A[index--]=B[j--];
        }
    }
}
