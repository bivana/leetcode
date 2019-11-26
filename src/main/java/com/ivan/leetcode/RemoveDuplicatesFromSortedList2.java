package com.ivan.leetcode;

import org.junit.Test;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * */
public class RemoveDuplicatesFromSortedList2 {

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(4);
        ListNode l7=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        ListNode rs=deleteDuplicates(l1);
        ListNode.show(l1);
        System.out.println();

        ListNode b1=new ListNode(1);
        ListNode b2=new ListNode(1);
        ListNode b3=new ListNode(1);
        ListNode b4=new ListNode(2);
        ListNode b5=new ListNode(3);
        b1.next=b2;
        b2.next=b3;
        b3.next=b4;
        b4.next=b5;
        ListNode rs2=deleteDuplicates(b1);
        ListNode.show(rs2);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        while (cur!=null){
            ListNode next=cur.next;
            int count=0;
            while (next!=null&& next.val==cur.val){
                next=next.next;
                count++;
            }
            if(count>0){
                pre.next=next;
            }else{
                pre=cur;
            }
            cur=next;
        }
        return dummy.next;
    }
}
