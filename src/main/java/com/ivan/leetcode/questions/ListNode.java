package com.ivan.leetcode.questions;

/**
 * 链表节点对象
 * */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }


    public static ListNode create(int i){
        ListNode node=new ListNode(i);
        for (i--;i>0;i--){
            ListNode pre=new ListNode(i);
            pre.next=node;
            node=pre;
        }
        return node;
    }

    public static ListNode create(int[] nums){
        if(nums==null|| nums.length==0){
            return null;
        }
        ListNode head=new ListNode(nums[0]);
        ListNode pre=head;
        for(int i=1;i<nums.length;i++){
            ListNode listNode=new ListNode(nums[i]);
            pre.next=listNode;
            pre=listNode;
        }
        return head;
    }


}
