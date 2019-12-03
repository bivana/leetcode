package com.ivan.leetcode.util;

import java.util.List;

public class ShowUtil {

    public static void showIntArray(int[] nums){
        for(int i:nums){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void showListMatrix(List<List<Integer>> list){
        for(List<Integer> l:list){
            for(Integer i:l){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
