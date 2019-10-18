package com.ivan.leetcode;

import org.junit.Test;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * */
public class MergeKSortedLists {

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(5);
        l1.next=l2;
        l2.next=l3;

        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(3);
        ListNode a3=new ListNode(4);
        a1.next=a2;
        a2.next=a3;

        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(6);
        b1.next=b2;

        ListNode result=mergeKLists(new ListNode[]{l1,a1,b1});
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }
}
