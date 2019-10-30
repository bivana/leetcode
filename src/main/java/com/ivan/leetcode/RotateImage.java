package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * */
public class RotateImage {

    @Test
    public void test(){
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int[] a:matrix){
            for(int i:a){
                System.out.print(i+",");
            }
            System.out.println();

        }
//        Assert.assertArrayEquals(new int[]{7,4,1},matrix[0]);
//        Assert.assertArrayEquals(new int[]{8,5,2},matrix[1]);
//        Assert.assertArrayEquals(new int[]{9,6,3},matrix[2]);
    }

    public void rotate(int[][] matrix) {
        int i=0;//行
        int j=0;//列
        int n=matrix.length-1;
        int temp=matrix[j][n-i];
        matrix[j][n-i]=matrix[i][j];
        matrix[0][0]=temp;
        i=n-j;
        j=n-i;
        while (i!=0 || j!=0){
            temp=matrix[j][n-i];
            matrix[j][n-i]=matrix[i][j];
            matrix[0][0]=temp;
            i=j;
            j=n-i;
        }
    }
}
