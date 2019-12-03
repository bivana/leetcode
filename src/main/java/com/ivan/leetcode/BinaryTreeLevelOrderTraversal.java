package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * */
public class BinaryTreeLevelOrderTraversal {

    @Test
    public void test(){
        TreeNode treeNode=new TreeNode(3);
        TreeNode t1=new TreeNode(9);
        treeNode.left=t1;
        TreeNode t2=new TreeNode(20);
        treeNode.right=t2;
        TreeNode t3=new TreeNode(15);
        t2.left=t3;
        TreeNode t4=new TreeNode(7);
        t2.right=t4;

        List<List<Integer>> list=levelOrder(treeNode);
        ShowUtil.showListMatrix(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        levelOrder(root,list,0);
        return list;
    }

    public void levelOrder(TreeNode node,List<List<Integer>> list,int i) {
        if(node==null){
            return;
        }
        while(i>list.size()-1){
            List<Integer> sub=new ArrayList<Integer>();
            list.add(sub);
        }
        list.get(i).add(node.val);
        levelOrder(node.left,list,i+1);
        levelOrder(node.right,list,i+1);
    }
}
