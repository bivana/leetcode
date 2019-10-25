package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * */
public class MaximumDepthOfBinaryTree {

    @Test
    public void test(){
        TreeNode treeNode=new TreeNode(3);
        TreeNode t9=new TreeNode(9);
        treeNode.left=t9;
        TreeNode t20=new TreeNode(20);
        treeNode.right=t20;
        t20.left=new TreeNode(15);
        t20.right=new TreeNode(7);
        Assert.assertEquals(3,maxDepth(treeNode));

    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
