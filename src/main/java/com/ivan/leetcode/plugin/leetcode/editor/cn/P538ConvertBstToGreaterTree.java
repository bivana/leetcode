package com.ivan.leetcode.plugin.leetcode.editor.cn;
//538 把二叉搜索树转换为累加树
//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
//sum-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 682 👎 0

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class P538ConvertBstToGreaterTree{
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

private Solution solution=new Solution();

@Test
public void test(){
    TreeNode treeNode=TreeNode.create(new Integer[]{1,2,3,4,5,6,7});
    ShowUtil.showTreeNode(solution.convertBST(treeNode));
}

class Solution {



    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum; node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

//    public TreeNode convertBST(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        Stack<TreeNode> stack=new Stack<>();
//        Set<TreeNode> set=new HashSet<>();
//        stack.push(root);
//        int sum=0;
//        while (!stack.isEmpty()){
//            TreeNode treeNode=stack.pop();
//            if(set.contains(treeNode)){
//                sum+=treeNode.val;
//                treeNode.val=sum;
//            }else{
//                if(treeNode.left!=null){
//                    stack.push(treeNode.left);
//                }
//                stack.push(treeNode);
//                set.add(treeNode);
//                if(treeNode.right!=null){
//                    stack.push(treeNode.right);
//                }
//            }
//        }
//        return root;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}