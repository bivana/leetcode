package com.ivan.leetcode.plugin.leetcode.editor.cn;

//687. 最长同值路径
// 给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 637 👎 0

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class P687LongestUnivaluePath{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(2,solution.longestUnivaluePath(TreeNode.create(new Integer[]{1,4,5,4,4,null,5})));
        Assert.assertEquals(2,solution.longestUnivaluePath(TreeNode.create(new Integer[]{5,4,5,1,1,null,5})));
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

        public int longestUnivaluePath(TreeNode root) {
            ans=0;
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left=dfs(root.left)+1;
            int right=dfs(root.right)+1;
            if(root.left==null||root.left.val!=root.val){
                left=0;
            }
            if(root.right==null||root.right.val!=root.val){
                right=0;
            }
            ans=Math.max(ans,left+right);
            return Math.max(left,right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
