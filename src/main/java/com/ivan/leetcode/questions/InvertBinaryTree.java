package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * */
public class InvertBinaryTree {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(7);
        TreeNode t4=new TreeNode(1);
        TreeNode t5=new TreeNode(3);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(9);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        ShowUtil.showTreeNode(t1);
        System.out.println("------------after");
        ShowUtil.showTreeNode(invertTree(t1));
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        TreeNode treeNode=null;
        while (!deque.isEmpty()){
            treeNode=deque.poll();
            TreeNode tmp=treeNode.left;
            treeNode.left=treeNode.right;
            treeNode.right=tmp;
            if(treeNode.left!=null){
                deque.add(treeNode.left);
            }
            if(treeNode.right!=null){
                deque.add(treeNode.right);
            }
        }
        return root;
    }


}
