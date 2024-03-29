package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 223. 矩形面积
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 *
 * 示例 1：
 *
 * Rectangle Area
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 *
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *
 *
 * 提示：
 *
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 * */
public class RectangleArea {

    @Test
    public void test(){
        Assert.assertEquals(16,computeArea(-2,-2,2,2,-2,-2,2,2));
        Assert.assertEquals(45,computeArea(-3,0,3,4,0,-1,9,2));
    }

    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA=(ax2-ax1)*(ay2-ay1);
        int areaB=(bx2-bx1)*(by2-by1);
        int repeatX=getSingleLine(ax1,ax2,bx1,bx2);
        int repeatY=getSingleLine(ay1,ay2,by1,by2);
        int repeatArea=repeatX*repeatY;
        int totalArea=areaA+areaB-repeatArea;
        return totalArea;
    }

    public int getSingleLine(int a1,int a2,int b1,int b2){
        int repeat1=0;
        int repeat2=0;
        if(a1>a2){
            int tmp=a1;
            a1=a2;
            a2=tmp;
        }
        if(b1>b2){
            int tmp=b1;
            b1=b2;
            b2=tmp;
        }
        //交换，始终保证a1<b1
        if(a1>b1){
            int tmp1=a1;
            int tmp2=a2;
            a1=b1;
            a2=b2;
            b1=tmp1;
            b2=tmp2;
        }
        //区域A做区域B的左边
        if(a1<=b1){
            //区域相交
            if(a2>=b1){
                repeat1=b1;
                //包含关系
                if(b2<=a2){
                    repeat2=b2;
                }else{
                    repeat2=a2;
                }
            }
        }
        return repeat2-repeat1;

    }
}
