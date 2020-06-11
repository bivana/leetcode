package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 所谓中序遍历，先遍历左节点，再遍历跟节点，最后遍历右节点
 * */
public class BinaryTreeInorderTraversal {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.left=t3;

        Assert.assertArrayEquals(new Integer[]{1,3,2}, inorderTraversal(t1).toArray());
    }

    /**
     * 迭代法
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null){
            return list;
        }

        Stack<TreeNode> stack= new Stack<TreeNode>();
        stack.push(root);
        TreeNode treeNode=null;
        while (!stack.empty()){
            treeNode=stack.pop();
            if(treeNode.left!=null){
                TreeNode left=treeNode.left;
                treeNode.left=null;
                stack.push(treeNode);
                stack.push(left);
                continue;
            }
            list.add(treeNode.val);
            if(treeNode.right!=null){
                stack.push(treeNode.right);
            }
        }
        return list;
    }

    /**
     * 递归法
     * */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        inorderTraversal(root,list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

}
