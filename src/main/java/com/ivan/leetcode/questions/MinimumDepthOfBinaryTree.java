package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * */
public class MinimumDepthOfBinaryTree {

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
        Assert.assertEquals(2,minDepth(t1));

        TreeNode s1=new TreeNode(3);
        TreeNode s2=new TreeNode(9);
        s1.left=s2;
        Assert.assertEquals(2,minDepth(s1));

        TreeNode l1=new TreeNode(1);
        TreeNode l2=new TreeNode(2);
        TreeNode l3=new TreeNode(3);
        TreeNode l4=new TreeNode(4);
        TreeNode l5=new TreeNode(5);
        l1.left=l2;
        l1.right=l3;
        l2.left=l4;
        l3.right=l5;
        Assert.assertEquals(3,minDepth(l1));
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(left==0 ){
            return 1+right;
        }else if(right==0){
            return 1+left;
        }else{
            return 1+Math.min(left,right);
        }
    }

}
