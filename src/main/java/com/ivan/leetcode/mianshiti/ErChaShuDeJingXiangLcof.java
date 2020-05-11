package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 通过次数20,250提交次数25,755
 * */
public class ErChaShuDeJingXiangLcof {

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
        TreeNode t=mirrorTree(t1);
        ShowUtil.showTreeNode(t);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            TreeNode temp=treeNode.left;
            treeNode.left=treeNode.right;
            treeNode.right=temp;
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
        }
        return root;
    }
}
