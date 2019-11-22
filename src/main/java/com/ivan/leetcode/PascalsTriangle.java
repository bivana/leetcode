package com.ivan.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 在真实的面试中遇到过这道题？
 * */
public class PascalsTriangle {

    @Test
    public void test(){
        List<List<Integer>> list=generate(5);
        for(List<Integer> sub:list){
            for(Integer i:sub){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(numRows<=0){
            return list;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<Integer>();
            int j=0;
            while (j<i){
                if(j==0){
                    row.add(1);
                }else{
                    row.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }
                j++;
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }

    public void show(List<List<Integer>> list){
        for(List<Integer> sub:list){
            for(Integer i:sub){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
