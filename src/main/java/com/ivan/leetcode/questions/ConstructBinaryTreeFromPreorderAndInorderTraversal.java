package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 通过次数48,825提交次数75,776
 * */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    public void test(){
        TreeNode treeNode=buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        ShowUtil.showTreeNode(treeNode);

//        TreeNode treeNode=buildTree(new int[]{1,2},new int[]{1,2});
//        ShowUtil.showTreeNode(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode= buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preorder==null ||preorder.length==0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length){
            return null;
        }
        if(preStart>=preorder.length){
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[preStart]);
        //查找下标
        int index=inStart;
        for(;index<=inEnd;index++){
            if(inorder[index]==preorder[preStart]){
                break;
            }
        }
        if(index>inStart){
            treeNode.left=buildTree(preorder,preStart+1,preStart+(index-inStart),inorder,inStart,index-1);
        }
        if(index<inEnd){
            treeNode.right=buildTree(preorder,preStart+(index-inStart)+1,preEnd,inorder,index+1,inEnd);
        }
        return treeNode;
    }
}
