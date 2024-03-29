package com.ivan.leetcode.plugin.leetcode.editor.cn;
//450 删除二叉搜索树中的节点
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
// Related Topics 树 二叉搜索树 二叉树 👍 798 👎 0

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class P450DeleteNodeInABst{


    public Solution solution=new Solution();

    @Test
    public void test(){
        TreeNode treeNode=solution.deleteNode(TreeNode.create(new Integer[]{3,1,4,null,2}),2);
        ShowUtil.showTreeNode(treeNode);
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


    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur=root;
        TreeNode pre=null;
        boolean isLeft=true;
        while (cur!=null){
            if(cur.val==key){
                //删除节点，采用左节点上移
                TreeNode next=cur.left;
                if(next==null){
                    next=cur.right;
                }else{
                    TreeNode right=next;
                    while (right!=null&&right.right!=null){
                        right=right.right;
                    }
                    if(right!=null){
                        right.right=cur.right;
                    }
                }


                if(pre!=null){
                    if(isLeft){
                        pre.left=next;
                    }else{
                        pre.right=next;
                    }
                }else{
                    root=next;
                }
                return root;

            }else if(key<cur.val){
                pre=cur;
                cur=cur.left;
                isLeft=true;
            }else{
                pre=cur;
                cur=cur.right;
                isLeft=false;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}