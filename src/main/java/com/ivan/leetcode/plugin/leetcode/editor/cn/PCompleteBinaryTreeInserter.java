package com.ivan.leetcode.plugin.leetcode.editor.cn;

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 *
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *
 *
 * 提示：
 *
 * 树中节点数量范围为 [1, 1000]
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000
 * 每个测试用例最多调用 insert 和 get_root 操作 104 次
 * 通过次数13,239提交次数19,750
 * */
public class PCompleteBinaryTreeInserter {

    @Test
    public void test(){
        TreeNode treeNode=TreeNode.create(new Integer[]{1,2});
        CBTInserter cbtInserter=new CBTInserter(treeNode);
        Assert.assertEquals(1,cbtInserter.insert(3));
        Assert.assertEquals(2,cbtInserter.insert(4));
        ShowUtil.showTreeNode(cbtInserter.get_root());
    }

    class CBTInserter {

        TreeNode root;

        Queue<TreeNode> queue=new ArrayDeque<>();

        public CBTInserter(TreeNode root) {
            this.root=root;
            queue.add(root);
            ana:while (true){
                int n=queue.size();
                for(int i=0;i<n;i++){
                    TreeNode treeNode=queue.peek();
                    if(treeNode.left==null){
                        break ana;
                    }
                    queue.add(treeNode.left);
                    if(treeNode.right==null){
                        break ana;
                    }
                    queue.poll();
                    queue.add(treeNode.right);
                }
            }
        }

        public int insert(int val) {
            TreeNode p=queue.peek();
            if(p.left==null){
                p.left=new TreeNode(val);
                queue.add(p.left);
            }else{
                p.right=new TreeNode(val);
                queue.add(p.right);
                queue.poll();
            }
            return p.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
