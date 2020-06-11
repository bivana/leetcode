package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
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
 * 通过次数20,566提交次数25,650
 * */
public class RotateMatrixLcci {

    @Test
    public void test(){
        int[][] matrix1=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix1);
        ShowUtil.showIntMatrix(matrix1);

        System.out.println(">>>>>>>>>>>>>>");
        int[][] matrix2=new int[][]{{5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        rotate(matrix2);
        ShowUtil.showIntMatrix(matrix2);
    }

    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int end=len-1;
        for(int i=0;i<=len/2-1;i++){
            for(int j=i;j<end-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[end-j][i];
                matrix[end-j][i]=matrix[end-i][end-j];
                matrix[end-i][end-j]=matrix[j][end-i];
                matrix[j][end-i]=temp;
            }
        }

    }
}
