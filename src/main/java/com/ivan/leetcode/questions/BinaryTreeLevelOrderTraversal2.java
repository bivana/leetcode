package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * */
public class BinaryTreeLevelOrderTraversal2 {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        List<List<Integer>> list=levelOrderBottom(t1);
        ShowUtil.showListMatrix(list);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        insert(root,list,0);
        Collections.reverse(list);
        return list;
    }

    private void insert(TreeNode treeNode,List<List<Integer>> list,int level){
        if(treeNode==null){
            return;
        }
        if(list.size()<=level){
            List<Integer> l=new ArrayList<Integer>();
            list.add(l);
        }
        list.get(level).add(treeNode.val);
        insert(treeNode.left,list,level+1);
        insert(treeNode.right,list,level+1);
    }
}
