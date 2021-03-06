package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 通过次数38,974提交次数83,191
 * 在真实的面试中遇到过这道题？
 * */
public class SubtreeOfAnotherTree {

    @Test
    public void test(){
        Assert.assertEquals(false,isSubtree(TreeNode.create(new Integer[]{3,4,5,1,2,null,null,null,null,0,null}),TreeNode.create(new Integer[]{4,1,2})));

        Assert.assertEquals(false,isSubtree(TreeNode.create(new Integer[]{3,4,5,1,null,2}),TreeNode.create(new Integer[]{3,1,2})));

        Assert.assertEquals(true,isSubtree(TreeNode.create(new Integer[]{1,1}),TreeNode.create(new Integer[]{1})));

        Assert.assertEquals(true,isSubtree(TreeNode.create(new Integer[]{3,4,5,1,2}),TreeNode.create(new Integer[]{4,1,2})));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        if(s.val==t.val){
            return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
        }
        return false;
    }
}
