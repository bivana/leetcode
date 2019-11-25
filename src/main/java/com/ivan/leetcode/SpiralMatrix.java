package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 在真实的面试中遇到过这道题？
 * */
public class SpiralMatrix {

    @Test
    public void test(){
        List<Integer> rs=spiralOrder(new int[][]{{1, 2, 3 },{4, 5, 6},{7, 8, 9 }});
        Assert.assertArrayEquals(new Integer[]{1,2,3,6,9,8,7,4,5},rs.toArray(new Integer[rs.size()]));
        rs=spiralOrder(new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}});
        Assert.assertArrayEquals(new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7},rs.toArray(new Integer[rs.size()]));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix.length==0){
            return list;
        }
        int startX=0;//x轴
        int endX=matrix[0].length-1;
        int startY=0;
        int endY=matrix.length-1;
        String status="right";
        int x=0;
        int y=0;
        while (startX<=endX && startY<=endY){
            list.add(matrix[y][x]);
            if("right".equals(status)){
                if(x<endX){
                    x++;
                }else if(x==endX){
                    //第一行用完
                    y++;
                    startY++;
                    status="down";//状态改为向下
                }else{
                    throw new IllegalArgumentException();
                }
            }else if("down".equals(status)){
                if(y<endY){
                    y++;
                }else if(y==endY){
                    x--;
                    endX--;
                    status="left";
                }else {
                    throw new IllegalArgumentException();
                }
            }else if("left".equals(status)){
                if(x>startX){
                    x--;
                }else if(x==startX){
                    y--;
                    endY--;
                    status="up";
                }else{
                    throw new IllegalArgumentException();
                }
            }else if("up".equals(status)){
                if(y>startY){
                    y--;
                }else if(y==startY){
                    x++;
                    startX++;
                    status="right";
                }else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return list;
    }

    public void show(List<Integer> list){
        for(int i:list){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
