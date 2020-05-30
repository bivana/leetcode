package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * */
public class FlattenBinaryTreeToLinkedList {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        t5.right=t6;
        flatten(t1);
        ShowUtil.showTreeNode(t1);
    }

    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode tempRight=root.right;
                TreeNode leftLastRight=findLastRight(root.left);
                root.right=root.left;
                root.left=null;
                leftLastRight.right=tempRight;
            }
            root=root.right;
        }
    }

    public TreeNode findLastRight(TreeNode treeNode){
        while (treeNode.right!=null){
            treeNode=treeNode.right;
        }
        return treeNode;
    }

    /**
     * stack 处理
     * */
    public void flatten2(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        if(root.right!=null){
            stack.push(root.right);
        }
        if(root.left!=null){
            stack.push(root.left);
        }
        TreeNode last=root;
        while (!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            last.left=null;
            last.right=treeNode;
            last=treeNode;
            if(treeNode.right!=null){
                stack.push(treeNode.right);
            }
            if(treeNode.left!=null){
                stack.push(treeNode.left);
            }
        }
    }
}
