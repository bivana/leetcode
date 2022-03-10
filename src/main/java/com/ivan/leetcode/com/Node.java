package com.ivan.leetcode.com;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public static Node create(Integer[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        Node head=new Node();
        Node curHead=head;//当前的头部
        Node pre=head;//之前的
        int i=0;
        while (i<nums.length){
            if(nums[i]!=null){
                //前一条为空时
                if(i>0&&nums[i-1]==null){
                    Node node=new Node();
                    node.val=nums[i];
                    curHead.child=node;
                    curHead=node;
                    pre=node;
                }else{
                    Node node=new Node();
                    node.val=nums[i];
                    node.prev=pre;
                    pre.next=node;
                    pre=node;
                }

            }else{
                curHead=curHead.next;
            }
            i++;
        }
        return head.next;

    }
}
