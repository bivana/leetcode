package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * */
public class SameTree {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(2);
        TreeNode a3=new TreeNode(3);
        a1.left=a2;
        a1.right=a3;
        Assert.assertEquals(true,isSameTree(a1,t1));

        TreeNode b1=new TreeNode(1);
        TreeNode b2=new TreeNode(2);
        b1.left=b2;

        TreeNode c1=new TreeNode(1);
        TreeNode c2=new TreeNode(2);
        c1.right=c2;
        Assert.assertEquals(false,isSameTree(b1,c1));

        TreeNode d1=new TreeNode(1);
        TreeNode d2=new TreeNode(2);
        TreeNode d3=new TreeNode(3);
        d1.left=d3;
        d1.right=d2;
        Assert.assertEquals(false,isSameTree(t1,d1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
