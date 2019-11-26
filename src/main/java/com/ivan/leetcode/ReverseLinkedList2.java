package com.ivan.leetcode;

import org.junit.Test;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * */
public class ReverseLinkedList2 {

    @Test
    public void test(){
        ListNode listNode=ListNode.create(5);
        ListNode rs=reverseBetween(listNode,0,3);
        ListNode.show(rs);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count=0;
        ListNode fakeHead=new ListNode(0);
        fakeHead.next=head;
        ListNode pre=fakeHead;
        for(int i=0;i<m-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        for(int i=m;i<n;i++){
            ListNode temp=cur.next;
            cur.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
        }
        return fakeHead.next;
    }
}
