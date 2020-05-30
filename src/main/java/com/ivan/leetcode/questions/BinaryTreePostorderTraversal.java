package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * */
public class BinaryTreePostorderTraversal {

    @Test
    public void test() {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        Assert.assertArrayEquals(new Integer[]{3,2,1},postorderTraversal(t1).toArray());

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<Integer>();
        TreeNode cur=root;
        TreeNode last=null;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.peek();
                if(cur.right!=null && cur.right!=last){
                    cur=cur.right;
                }else{
                    ans.add(cur.val);
                    last=cur;
                    stack.pop();
                    cur=null;
                }
            }

        }
        return ans;
    }
}
