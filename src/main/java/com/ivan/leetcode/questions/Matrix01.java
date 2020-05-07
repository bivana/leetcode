package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 通过次数31,417提交次数70,424
 * */
public class Matrix01 {

    @Test
    public void test(){
        int[][] m1=updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        ShowUtil.showIntMatrix(m1);
        System.out.println("-----------");
        int[][] m2=updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        ShowUtil.showIntMatrix(m2);
    }

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return matrix;
        }
        Queue<int[]> queue=new ArrayDeque<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[] rd=new int[]{0,0,1,-1};
        int[] cd=new int[]{1,-1,0,0};
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int[] pos=queue.poll();
                int min=Integer.MAX_VALUE;
                for(int a=0;a<rd.length;a++){
                    int i=pos[0]+rd[a];
                    int j=pos[1]+cd[a];
                    if(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
                        min=Math.min(min,matrix[i][j]);
                    }
                }
                if(min>=matrix[pos[0]][pos[1]]){
                    matrix[pos[0]][pos[1]]=min+1;
                    queue.offer(pos);
                }
            }
        }
        return matrix;

    }
}
