package com.ivan.leetcode.plugin.leetcode.editor.cn;
//515 在每个树行中找最大值
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 217 👎 0

import com.ivan.leetcode.questions.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P515FindLargestValueInEachTreeRow{
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                TreeNode treeNode=queue.poll();
                max=Math.max(treeNode.val,max);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}