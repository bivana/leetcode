package com.ivan.leetcode;

import org.junit.Test;

/**
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * */
public class RotateList {

    @Test
    public void test(){
        ListNode listNode=ListNode.create(5);
        ListNode rs=rotateRight(listNode,2);
        ListNode.show(rs);
        System.out.println();

        ListNode l1=new ListNode(0);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        ListNode rs2=rotateRight(l1,4);
        ListNode.show(rs2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int deep=1;
        ListNode temp=head;
        while (temp.next!=null){
            deep++;
            temp=temp.next;
        }
        temp.next=head;//连成一个环形链表
        for(int i=0;i<deep-k%deep;i++){
            temp=temp.next;
        }
        ListNode rs=temp.next;
        temp.next=null;
        return rs;
    }
}
