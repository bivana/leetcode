package com.ivan.leetcode.questions;

import com.ivan.leetcode.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * */
public class BinaryTreeRightSideView {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t2.right=t5;
        t1.right=t3;
        t3.right=t4;
        Assert.assertArrayEquals(new Integer[]{1,3,4},rightSideView(t1).toArray(new Integer[]{}));

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode=queue.poll();
                if(i==0){
                    rs.add(treeNode.val);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
            }
        }

        return rs;
    }
}
