package com.ivan.leetcode.questions;

import com.ivan.leetcode.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 通过次数49,432提交次数64,942
 * 在真实的面试中遇到过这道题？
 * */
public class MergeTwoBinaryTrees {

    @Test
    public void test(){
        TreeNode treeNode=mergeTrees(TreeNode.create(new Integer[]{1,3,2,5}),TreeNode.create(new Integer[]{2,1,3,null,4,null,7}));
        ShowUtil.showTreeNode(treeNode);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode treeNode=new TreeNode(t1.val+t2.val);
        treeNode.left=mergeTrees(t1.left,t2.left);
        treeNode.right=mergeTrees(t1.right,t2.right);
        return treeNode;
    }
}
