package com.ivan.leetcode;

import org.junit.Test;

/**
 * 206. 反转链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * */
public class ReverseLinkedList {

    @Test
    public void test(){
        ListNode listNode=ListNode.create(5);
        listNode=reverseList(listNode);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 递归版本
     * */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode fake=new ListNode(-1);
//        fake.next=head;
//        ListNode temp=fake.next;
//        while (temp!=null && temp.next!=null){
//            ListNode next=temp.next;
//            temp.next=temp.next.next;
//            next.next=fake.next;
//            fake.next=next;
//
//        }
//        return fake.next;
//    }
}
