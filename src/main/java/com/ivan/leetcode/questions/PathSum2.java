package com.ivan.leetcode.questions;

import com.ivan.leetcode.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 通过次数34,270提交次数58,024
 * */
public class PathSum2 {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(8);
        TreeNode t4=new TreeNode(11);
        TreeNode t5=new TreeNode(13);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(2);
        TreeNode t9=new TreeNode(5);
        TreeNode t10=new TreeNode(1);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.left=t5;
        t3.right=t6;
        t4.left=t7;
        t4.right=t8;
        t6.left=t9;
        t6.right=t10;
        List<List<Integer>> list=pathSum(t1,22);
        ShowUtil.showListMatrix(list);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rs=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        pathSum(root,rs,temp,sum);
        return rs;
    }

    public void pathSum(TreeNode treeNode,List<List<Integer>> rs,List<Integer> temp,int remain){
        if(treeNode==null){
            return;
        }
        temp.add(treeNode.val);
        remain=remain-treeNode.val;
        if(remain==0 && treeNode.left==null && treeNode.right==null){
            rs.add(new ArrayList<>(temp));
        }
        pathSum(treeNode.left,rs,temp,remain);
        pathSum(treeNode.right,rs,temp,remain);
        temp.remove(temp.size()-1);
    }
}
