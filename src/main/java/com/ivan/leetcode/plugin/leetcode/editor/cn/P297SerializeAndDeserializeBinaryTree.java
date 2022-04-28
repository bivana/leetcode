package com.ivan.leetcode.plugin.leetcode.editor.cn;
//297 二叉树的序列化与反序列化
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 837 👎 0

import com.ivan.leetcode.questions.TreeNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class P297SerializeAndDeserializeBinaryTree{

    private Solution solution=new Solution();

    @Test
    public void test2(){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(null);
        System.out.println(deque.poll());
    }

    @Test
    public void test(){
        Codec c=new Codec();
        TreeNode treeNode=TreeNode.create(new Integer[]{1,2,3,null,null,4,5});
        String s=c.serialize(treeNode);
        System.out.println(s);
        TreeNode rs=c.deserialize(s);
        ShowUtil.showTreeNode(rs);
    }

    @Test
    public void test3(){
        Codec c=new Codec();
        String s=c.serialize(null);
        System.out.println(s);
        TreeNode rs=c.deserialize(s);
        ShowUtil.showTreeNode(rs);
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
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if(treeNode.left==null){
                sb.append(",").append("n");
            }else{
                sb.append(",").append(treeNode.left.val);
                queue.add(treeNode.left);
            }
            if(treeNode.right==null){
                sb.append(",").append("n");
            }else{
                sb.append(",").append(treeNode.right.val);
                queue.add(treeNode.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] array=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(array[0]));
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        for(int i=1;i<array.length;i=i+2){
            TreeNode treeNode=deque.poll();
            if(!array[i].equals("n")){
                TreeNode l=new TreeNode(Integer.parseInt(array[i]));
                treeNode.left=l;
                deque.add(l);
            }
            if(!array[i+1].equals("n")){
                TreeNode r=new TreeNode(Integer.parseInt(array[i+1]));
                treeNode.right=r;
                deque.add(r);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}