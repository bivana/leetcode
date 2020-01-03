package com.ivan.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * */
public class RemoveDuplicatesFromSortedList {

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        deleteDuplicates(l1);
        ListNode.show(l1);

        System.out.println();

        ListNode r1=new ListNode(1);
        ListNode r2=new ListNode(1);
        ListNode r3=new ListNode(2);
        ListNode r4=new ListNode(3);
        ListNode r5=new ListNode(3);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;
        deleteDuplicates(r1);
        ListNode.show(r1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> set=new HashSet<Integer>();
        set.add(head.val);
        ListNode cur=head;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;
            while (next!=null && set.contains(next.val)){
                cur.next=next.next;
                next=cur.next;
            }
            if(next!=null){
                set.add(next.val);
            }

            cur=cur.next;
        }
        return head;
    }
}
