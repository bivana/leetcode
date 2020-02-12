package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * */
public class BinaryTreePreorderTraversal {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        List<Integer> list=preorderTraversal(t1);
        Assert.assertArrayEquals(new Integer[]{1,2,3},list.toArray(new Integer[list.size()]));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs=new ArrayList<>();
        if(root==null){
            return rs;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            rs.add(treeNode.val);
            if(treeNode.right!=null){
                stack.push(treeNode.right);
            }
            if(treeNode.left!=null){
                stack.push(treeNode.left);
            }
        }
        return rs;
    }
}
