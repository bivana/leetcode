package com.ivan.leetcode;

import org.junit.Test;

/**
 * 21. 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * */
public class MergeTwoSortedLists {


    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        l1.next=l2;
        ListNode l4=new ListNode(4);
        l2.next=l4;

        ListNode r1=new ListNode(1);
        ListNode r2=new ListNode(3);
        ListNode r3=new ListNode(4);
        r1.next=r2;
        r2.next=r3;
        ListNode result=mergeTwoLists(l1,r1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode temp=result;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
            }else{
                temp.next=l2;
                temp=temp.next;
                l2=l2.next;
            }
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return result.next;
    }
}
