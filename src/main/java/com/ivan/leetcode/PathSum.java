package com.ivan.leetcode;

import org.junit.Test;

/**
 * 112. 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * */
public class PathSum {

    @Test
    public void test(){

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root,0,sum);
    }

    private boolean hasPathSum(TreeNode treeNode,int sum,int target){
        if(treeNode==null){
            return false;
        }
        sum+=treeNode.val;
        if(treeNode.left==null && treeNode.right==null && sum==target){
            return true;
        }
        return hasPathSum(treeNode.left,sum,target) || hasPathSum(treeNode.right,sum,target);
    }
}
