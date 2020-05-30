package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * */
public class DiameterOfBinaryTree {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        Assert.assertEquals(3,diameterOfBinaryTree(t1));
    }
    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        getDepth(root);
        return max;
    }

    public int getDepth(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        int l=getDepth(treeNode.left);
        int r=getDepth(treeNode.right);
        max=Math.max(max,l+r+1);
        return Math.max(l,r)+1;
    }


}
