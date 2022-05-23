package com.ivan.leetcode.plugin.leetcode.editor.cn;
//面试题 04.06 后继者
//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 119 👎 0

import com.ivan.leetcode.questions.TreeNode;

import java.util.Stack;

public class PSuccessorLcci{
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        TreeNode prev=null;
        while (!stack.isEmpty()||curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            if(prev==p){
                return curr;
            }
            prev=curr;
            curr=curr.right;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}