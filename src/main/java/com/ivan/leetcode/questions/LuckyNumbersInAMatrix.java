package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 * 通过次数24,985提交次数33,013
 * */
public class LuckyNumbersInAMatrix {

    @Test
    public void test(){
        Assert.assertArrayEquals(new Integer[]{15},luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}).toArray());
        Assert.assertArrayEquals(new Integer[]{12},luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}).toArray());
        Assert.assertArrayEquals(new Integer[]{7},luckyNumbers(new int[][]{{7,8},{1,2}}).toArray());
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] minRow=new int[matrix.length];
        Arrays.fill(minRow,Integer.MAX_VALUE);
        int[] maxColumn=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                minRow[i]=Math.min(minRow[i],matrix[i][j]);
                maxColumn[j]=Math.max(maxColumn[j],matrix[i][j]);
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int i:minRow){
            set.add(i);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:maxColumn){
            if(set.contains(i)){
                list.add(i);
            }
        }
        return list;

    }
}
