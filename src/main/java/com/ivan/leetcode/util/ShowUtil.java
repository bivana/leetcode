package com.ivan.leetcode.util;

import com.ivan.leetcode.questions.ListNode;
import com.ivan.leetcode.questions.TreeNode;

import java.util.List;

public class ShowUtil {

    public static void showIntArray(int[] nums){
        for(int i:nums){
            System.out.print(i+",");
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


    public static void showStringListMatrix(List<List<String>> list){
        for(List<String> l:list){
            for(String i:l){
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

    public static void showCharMatrix(char[][] matrix){
        for(char[] is:matrix){
            for(char i:is){
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

    public static void showListNode(ListNode listNode){
        if(listNode!=null){
            System.out.print(listNode.val);
            if(listNode.next!=null){
                System.out.print("==>");
            }
            showListNode(listNode.next);
        }

    }

    public static void showListNodeArray(ListNode[] listNodes){
        System.out.println(">>>>>>>>>>>>>start show showListNodeArray");
        for(ListNode listNode:listNodes){
            System.out.println(">>>>>");
            if(listNode!=null){
                System.out.print(listNode.val);
                if(listNode.next!=null){
                    System.out.print("==>");
                }
                showListNode(listNode.next);
            }
        }


    }
}
