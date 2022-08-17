package com.ivan.leetcode.plugin.leetcode.editor.cn;//
// 1302. 层数最深叶子节点的和
// 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 121 👎 0

import com.ivan.leetcode.questions.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

public class P1302DeepestLeavesSum{


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
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            int deep=1;
            int ans=0;
            Stack<TreeNode> stack=new Stack<>();
            Stack<Integer> deepStack=new Stack<>();
            stack.push(root);
            deepStack.push(1);
            while (!stack.isEmpty()){
                TreeNode treeNode=stack.pop();
                int curDeep=deepStack.pop();
                if(curDeep>deep){
                    ans=0;
                    deep=curDeep;
                    ans+=treeNode.val;
                }else if(curDeep==deep){
                    ans+=treeNode.val;
                }
                if(treeNode.left!=null){
                    stack.push(treeNode.left);
                    deepStack.push(curDeep+1);
                }
                if(treeNode.right!=null){
                    stack.push(treeNode.right);
                    deepStack.push(curDeep+1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}