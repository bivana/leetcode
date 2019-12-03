package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * */
public class SymmetricTree {

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t21=new TreeNode(2);
        TreeNode t22=new TreeNode(2);
        t1.left=t21;
        t1.right=t22;
        TreeNode t31=new TreeNode(3);
        TreeNode t32=new TreeNode(4);
        t21.left=t31;
        t21.right=t32;
        TreeNode t33=new TreeNode(4);
        TreeNode t34=new TreeNode(3);
        t22.left=t33;
        t22.right=t34;
        Assert.assertEquals(true,isSymmetric(t1));

        TreeNode l1=new TreeNode(1);
        TreeNode l21=new TreeNode(2);
        TreeNode l22=new TreeNode(2);
        l1.left=l21;
        l1.right=l22;
        TreeNode l31=new TreeNode(3);
        TreeNode l32=new TreeNode(3);
        l21.right=l31;
        l21.right=l32;
        Assert.assertEquals(false,isSymmetric(l1));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }else if(left!=null && right!=null){
            if(left.val==right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right , right.left)){
                return true;
            }
        }
        return false;
    }
}
