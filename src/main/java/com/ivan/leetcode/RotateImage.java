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
        showMatrix(matrix);
        rotate(matrix);
        showMatrix(matrix);
//        Assert.assertArrayEquals(new int[]{7,4,1},matrix[0]);
//        Assert.assertArrayEquals(new int[]{8,5,2},matrix[1]);
//        Assert.assertArrayEquals(new int[]{9,6,3},matrix[2]);
    }

    public void test2(){
        int[] nums=new int[]{1,2,3,4,5,6};
        for(int i=0;i<=nums.length/2;i++){
            int temp=nums[i];
        }
    }

    //单次循环旋转  对于单次任务点(i,j),四边形旋转四次换位：(i,j)-->(j,n-1-i)-->(n-1-i,n-1-j)-->(n-1-j,i)-->(i,j)
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }

    //先转置矩阵，然后翻转每一行 复杂度 ON2
    public void rotate2(int[][] matrix) {
        //rotage matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
            showMatrix(matrix);
        }
        showMatrix(matrix);
        //reverse each row
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=matrix[i].length/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[i].length-1-i];
                matrix[i][matrix[i].length-1-i]=temp;
            }
        }
    }

    private void showMatrix(int[][] matrix){
        for(int[] a:matrix){
            for(int i:a){
                System.out.print(i+",");
            }
            System.out.println();

        }
        System.out.println("-----------------");
    }
}
