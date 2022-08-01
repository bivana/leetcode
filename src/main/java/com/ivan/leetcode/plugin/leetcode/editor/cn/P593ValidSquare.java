package com.ivan.leetcode.plugin.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 593. 有效的正方形
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 *
 *
 * 示例 1:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 *
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 *
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 *
 *
 * 提示:
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -104 <= xi, yi <= 104
 * 通过次数15,802提交次数34,178
 * */
public class P593ValidSquare {

    @Test
    public void test(){
        Assert.assertEquals(true,validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,1}));
        Assert.assertEquals(false,validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,12}));
        Assert.assertEquals(true,validSquare(new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Double,Integer> map=new HashMap<>();
        putMap(map,p1,p2);
        putMap(map,p1,p3);
        putMap(map,p1,p4);
        putMap(map,p2,p3);
        putMap(map,p2,p4);
        putMap(map,p3,p4);
        if(map.size()!=2){
            return false;
        }
        Double[] key=new Double[2];
        map.keySet().toArray(key);
        Double board=key[0];//边
        Double slide=key[1];//斜
        if(board>slide){
            board=key[1];
            slide=key[0];
        }
        if(map.get(board)!=4){
            return false;
        }
        if(map.get(slide)!=2){
            return false;
        }
        if(slide!=board*2){
            return false;
        }
        return true;
    }

    public void putMap(Map<Double,Integer> map,int[] p1,int[] p2){
        double d=getSquarLenD(p1,p2);
        map.put(d,map.getOrDefault(d,0)+1);
    }


    public double getSquarLenD(int[] p1,int[] p2){
        return Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2);
    }
}
