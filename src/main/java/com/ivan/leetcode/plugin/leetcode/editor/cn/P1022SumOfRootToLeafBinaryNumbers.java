package com.ivan.leetcode.plugin.leetcode.editor.cn;
//1022 从根到叶的二进制数之和
//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。 
//
// 
// 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
// 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 1000] 范围内 
// Node.val 仅为 0 或 1 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 162 👎 0

import com.ivan.leetcode.questions.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class P1022SumOfRootToLeafBinaryNumbers{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(22,solution.sumRootToLeaf(TreeNode.create(new Integer[]{1,0,1,0,1,0,1})));
    }

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

    int ans=0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode treeNode,int curSum){
        curSum=(curSum<<1)+treeNode.val;
        if(treeNode.left==null&&treeNode.right==null){
            ans+=curSum;
            return;
        }
        if(treeNode.left!=null){
            dfs(treeNode.left,curSum);
        }
        if(treeNode.right!=null){
            dfs(treeNode.right,curSum);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}