package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * */
public class BinaryTreeZigzagLevelOrderTraversal {

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
        List<List<Integer>> list=zigzagLevelOrder(t1);
        ShowUtil.showListMatrix(list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.add(root);
        boolean leftToRight=true;//true从左到右，false 从右到左
        while (!deque.isEmpty()){
            List<Integer> intList=new ArrayList<>();
            list.add(intList);
            int size=deque.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode=deque.poll();
                intList.add(treeNode.val);
                if(treeNode.left!=null){
                    deque.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.add(treeNode.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(intList);
            }
            leftToRight=!leftToRight;
        }
        return list;
    }
}
