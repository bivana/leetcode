package com.ivan.leetcode.questions;

import com.ivan.leetcode.questions.ListNode;
import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * */
public class SwapNodesInPairs {

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode result=swapPairs(l1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode rs=new ListNode(0);
        rs.next=head;
        ListNode temp=rs;
        ListNode next=rs.next;
        ListNode nextNext=null;
        if(next!=null){
            nextNext=next.next;
        }
        while (next!=null && nextNext!=null){
            temp.next=nextNext;
            next.next=nextNext.next;
            nextNext.next=next;
            temp=next;
            next=temp.next;
            if(next!=null){
                nextNext=next.next;
            }
        }
        return rs.next;
    }
}
