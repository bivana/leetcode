package com.ivan.leetcode.plugin.leetcode.editor.cn;//给定一棵二叉树 root，返回所有重复的子树。
// 652. 寻找重复的子树
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 502 👎 0

import com.ivan.leetcode.questions.TreeNode;
import org.junit.Test;

import java.util.*;

public class P652FindDuplicateSubtrees{

    public Solution solution=new Solution();

    @Test
    public void test(){
//        List<TreeNode> list=solution.findDuplicateSubtrees(TreeNode.create(new Integer[]{1,2,3,4,null,2,4,null,null,4}));
        List<TreeNode> list=solution.findDuplicateSubtrees(TreeNode.create(new Integer[]{2,1,11,11,null,1}));
        System.out.println("aaa");
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
        
        List<TreeNode> ans=new ArrayList<>();

        private Map<String,Integer> map=new HashMap<>();
        
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return ans;
        }

        private String dfs(TreeNode root) {
            if(root==null){
                return "";
            }
            String key= root.val+"_"+dfs(root.left)+"_"+dfs(root.right);
            map.put(key,map.getOrDefault(key,0)+1);
            if(map.get(key)==2){
                ans.add(root);
            }
            return key;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
