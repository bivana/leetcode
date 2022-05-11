package com.ivan.leetcode.plugin.leetcode.editor.cn;
//449 序列化和反序列化二叉搜索树
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 295 👎 0

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class P449SerializeAndDeserializeBst{


    @Test
    public void test(){
        Codec codec=new Codec();
        TreeNode treeNode=TreeNode.create(new Integer[]{2,1,3});
        System.out.println(codec.serialize(treeNode));
        ShowUtil.showTreeNode(codec.deserialize(codec.serialize(treeNode)));
    }

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if(treeNode.left!=null){
                sb.append(",").append(treeNode.left.val);
                queue.add(treeNode.left);
            }else{
                sb.append(",").append("null");
            }
            if(treeNode.right!=null){
                sb.append(",").append(treeNode.right.val);
                queue.add(treeNode.right);
            }else{
                sb.append(",").append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||"".equals(data)){
            return null;
        }
        String[] nodes=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if(!"null".equals(nodes[i])){
                TreeNode left=new TreeNode(Integer.parseInt(nodes[i]));
                treeNode.left=left;
                queue.add(left);
            }
            i++;
            if(!"null".equals(nodes[i])){
                TreeNode right=new TreeNode(Integer.parseInt(nodes[i]));
                treeNode.right=right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}