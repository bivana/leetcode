package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 142. 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *  
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * */
public class LinkedListCycle2 {

    @Test
    public void test(){
        ListNode l1=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(0);
        ListNode l4=new ListNode(-4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l2;
        ListNode rs=detectCycle(l1);
        ShowUtil.showListNode(rs);

        ListNode t1=new ListNode(1);
        ListNode t2=new ListNode(2);
        t1.next=t2;
        t2.next=t1;
        ListNode tt=detectCycle(t1);
        ShowUtil.showListNode(t1);

        ListNode s1=new ListNode(1);
        ListNode ss=detectCycle(s1);
        ShowUtil.showListNode(ss);
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (true){
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }

        }
        while (true){
            if(head==slow){
                return head;
            }
            head=head.next;
            slow=slow.next;
        }

    }


}
