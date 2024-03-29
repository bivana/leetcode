package com.ivan.leetcode.questions;

import com.ivan.leetcode.com.com1.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * 提示：
 *
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 *
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * */
public class NAryTreePreorderTraversal {

    @Test
    public void test(){
        Node node=new Node(1);
        List<Node> list=new ArrayList<>();
        List<Node> list2=new ArrayList<>();
        list2.add(new Node(5));
        list2.add(new Node(6));
        Node node2=new Node(3);
        node2.children=list2;
        list.add(node2);
        list.add(new Node((2)));
        list.add(new Node(4));
        node.children=list;
        Assert.assertArrayEquals(new Integer[]{1,3,5,6,2,4},preorder(node).toArray(new Integer[0]));
//        Assert.assertArrayEquals(new Integer[]{1,2,3,6,7,11,14,4,8,12,5,9,13,10},preorder(Node.create(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14})).toArray(new Integer[0]));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            list.add(node.val);
            if(node.children!=null&&node.children.size()>0){
                for(int i=node.children.size()-1;i>=0;i--){
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }

}
