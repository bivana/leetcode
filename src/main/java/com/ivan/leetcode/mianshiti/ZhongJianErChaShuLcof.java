package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.questions.TreeNode;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ZhongJianErChaShuLcof {

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
