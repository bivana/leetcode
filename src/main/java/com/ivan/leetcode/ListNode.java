package com.ivan.leetcode;

/**
 * 链表节点对象
 * */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode create(int i){
        ListNode node=new ListNode(i);
        for (i--;i>0;i--){
            ListNode pre=new ListNode(i);
            pre.next=node;
            node=pre;
        }
        return node;
    }

    public static void show(ListNode listNode){
        if(listNode!=null){
            System.out.print(listNode.val);
            if(listNode.next!=null){
                System.out.print("==>");
            }
            show(listNode.next);
        }

    }
}
