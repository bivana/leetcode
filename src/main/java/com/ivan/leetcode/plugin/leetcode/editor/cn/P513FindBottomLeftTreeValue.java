package com.ivan.leetcode.plugin.leetcode.editor.cn;
//513 找树左下角的值
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 310 👎 0

import com.ivan.leetcode.questions.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P513FindBottomLeftTreeValue{
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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        int ans=Integer.MIN_VALUE;
        while (!deque.isEmpty()){
            int len=deque.size();
            for(int i=0;i<len;i++){
                TreeNode treeNode=deque.poll();
                if(i==0){
                    ans=treeNode.val;
                }
                if(treeNode.left!=null){
                    deque.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    deque.add(treeNode.right);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}