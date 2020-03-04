package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 * */
public class BalancedBinaryTree {

    @Test
    public void test(){
        TreeNode b1=new TreeNode(1);
        TreeNode b2=new TreeNode(2);
        TreeNode b3=new TreeNode(2);
        TreeNode b4=new TreeNode(3);
        TreeNode b5=new TreeNode(3);
        TreeNode b6=new TreeNode(4);
        TreeNode b7=new TreeNode(4);
        b1.left=b2;
        b1.right=b3;
        b2.left=b4;
        b3.right=b5;
        b4.left=b6;
        b5.right=b7;
        Assert.assertEquals(false,isBalanced(b1));



        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        Assert.assertEquals(true,isBalanced(t1));

        TreeNode l1=new TreeNode(1);
        TreeNode l2=new TreeNode(2);
        TreeNode l3=new TreeNode(2);
        TreeNode l4=new TreeNode(3);
        TreeNode l5=new TreeNode(3);
        TreeNode l6=new TreeNode(4);
        TreeNode l7=new TreeNode(4);
        l1.left=l2;
        l1.right=l3;
        l2.left=l4;
        l2.right=l5;
        l4.left=l6;
        l4.right=l7;
        Assert.assertEquals(false,isBalanced(l1));
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(getDeep(root.left)-getDeep(root.right))>1){
            return false;
        }
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        return true;
    }

    public int getDeep(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        if(treeNode.left==null && treeNode.right==null){
            return 1;
        }
        return Math.max(getDeep(treeNode.left),getDeep(treeNode.right))+1;
    }
}
