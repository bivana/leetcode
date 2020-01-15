package com.ivan.leetcode.util;

import com.ivan.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static void showIntMatrix(int[][] matrix){
        for(int[] is:matrix){
            for(int i:is){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    /**
     * 显示数
     * */
    public static void showTreeNode(TreeNode treeNode) {
        if(treeNode==null){
            System.out.println(treeNode);
            return;
        }else{
            System.out.println(treeNode.val);
        }
        showTreeNode(treeNode.left);
        showTreeNode(treeNode.right);
    }
}
