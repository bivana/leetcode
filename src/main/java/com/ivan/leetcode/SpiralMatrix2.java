package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * */
public class SpiralMatrix2 {

    @Test
    public void test(){
        int[][] matrix=generateMatrix(3);
        ShowUtil.showIntMatrix(matrix);
    }

    /**
     * 优雅版
     * */
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    public int[][] generateMatrix(int n) {
        if(n<=0){
            return null;
        }
        int i=0;
        int j=0;
        int startCol=0;
        int endCol=n-1;
        int startRow=0;
        int endRow=n-1;
        int[][] rs=new int[n][n];
        int val=1;
        int maxVal=n*n;
        while (val<=maxVal){
            while (j<=endCol && j>=startCol){
                rs[i][j]=val;
                val++;
                if(j==endCol && i<endRow){
                    i++;
                    break;
                }
                j++;
            };
            startRow++;

            while (i<=endRow && i>=startRow){
                rs[i][j]=val;
                val++;
                if(i==endRow && j>startCol){
                    j--;
                    break;
                }
                i++;
            } ;
            endCol--;

            while (j>=startCol && j<=endCol){
                rs[i][j]=val;
                val++;
                if(j==startCol && i>startRow){
                    i--;
                    break;
                }
                j--;
            };
            endRow--;

            while (i>=startRow && i<=endRow){
                rs[i][j]=val;
                val++;
                if(i==startRow && j<endCol){
                    j++;
                    break;
                }
                i--;
            };
            startCol++;
        }
        return rs;
    }
}
