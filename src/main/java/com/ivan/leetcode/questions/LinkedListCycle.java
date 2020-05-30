package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *  
 * */
public class LinkedListCycle {

    @Test
    public void test(){
        ListNode l1=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(0);
        ListNode l4=new ListNode(-4);
        l4.next=l2;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        Assert.assertEquals(true,hasCycle(l1));

        l1=new ListNode(1);
        l2=new ListNode(2);
        l1.next=l2;
        l2.next=l1;
        Assert.assertEquals(true,hasCycle(l1));

        l1=new ListNode(1);
        Assert.assertEquals(false,l1);

        l1=new ListNode(1);
        l2=new ListNode(2);
        l1.next=l2;
        Assert.assertEquals(false,hasCycle(l1));

    }

    /**
     * 双指针发
     * */
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }

    /**
     * hash 法
     * */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> sets=new HashSet<ListNode>();
        while (head!=null){
            if(sets.contains(head)){
                return true;
            }else{
                sets.add(head);
                head=head.next;
            }
        }
        return false;
    }
}
