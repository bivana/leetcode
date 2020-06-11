package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * */
public class ValidateBinarySearchTree {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
//        Assert.assertEquals(true,isValidBST(t1));

        TreeNode a1=new TreeNode(5);
        TreeNode a2=new TreeNode(1);
        TreeNode a3=new TreeNode(4);
        TreeNode a4=new TreeNode(3);
        TreeNode a5=new TreeNode(6);
        a1.left=a2;
        a1.right=a3;
        a3.left=a4;
        a3.right=a5;
//        Assert.assertEquals(false,isValidBST(a1));

        TreeNode b1=new TreeNode(10);
        TreeNode b2=new TreeNode(5);
        TreeNode b3=new TreeNode(15);
        TreeNode b4=new TreeNode(6);
        TreeNode b5=new TreeNode(20);
        b1.left=b2;
        b1.right=b3;
        b3.left=b4;
        b3.right=b5;
        Assert.assertEquals(false,isValidBST(b1));
    }

    public boolean isValidBST(TreeNode root) {
        return isvalidBST(root,null,null);
    }

    public boolean isvalidBST(TreeNode node,Integer low,Integer high){
        if(node==null){
            return true;
        }
        if(low!=null && node.val<=low){
            return false;
        }
        if(high!=null && node.val>=high){
            return false;
        }
        return isvalidBST(node.left,low,node.val) && isvalidBST(node.right,node.val,high);
    }
}
