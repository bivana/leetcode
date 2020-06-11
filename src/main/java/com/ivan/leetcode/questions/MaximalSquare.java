package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 * 通过次数51,531提交次数121,811
 * 在真实的面试中遇到过这道题？
 * */
public class MaximalSquare {

    @Test
    public void test(){
        Assert.assertEquals(9,maximalSquare(new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}));

        Assert.assertEquals(16,maximalSquare(new char[][]{{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}}));
        Assert.assertEquals(4,maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'}
        ,{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
//                if(i==4&&j==3){
//                    System.out.println("......");
//                }
                if(matrix[i][j]=='1'){
                    int lastI=i-1;
                    int lastJ=j-1;
                    if(lastI>=0 && lastJ>=0 && dp[lastI][lastJ]>0){
                        //边上都是1
                        int num=dp[lastI][lastJ];
                        int temp=0;
                        for(int a=i-1;a>=i-num;a--){
                            if(matrix[a][j]=='1'){
                                temp++;

                            }else{
                                break;
                            }
                        }
                        num=temp;
                        temp=0;
                        if(num>0){
                            for(int a=j-1;a>=j-num;a--){
                                if(matrix[i][a]=='1'){
                                    temp++;
                                }else{
                                    break;
                                }
                            }
                        }
                        num=temp;
                        dp[i][j]=num+1;
                    }else{
                        dp[i][j]=1;
                    }
                }
                max=Math.max(max,dp[i][j]);
//                System.out.println("i:"+i+" j:"+j+" matrix:"+dp[i][j]);
            }
        }

        return max*max;

    }
}
