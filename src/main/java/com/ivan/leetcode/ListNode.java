package com.ivan.leetcode;

/**
 * 链表节点对象
 * */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode create(int num){
        ListNode node=new ListNode(num);
        for(int i=num-1;i>=1;i--){
            ListNode l=new ListNode(i);
            l.next=node;
            node=l;
        }
        return node;
    }
}
