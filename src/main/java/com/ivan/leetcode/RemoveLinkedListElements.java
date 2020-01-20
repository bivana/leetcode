package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * */
public class RemoveLinkedListElements {

    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(6);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(5);
        ListNode l7=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        ListNode rs=removeElements(l1,6);
        ShowUtil.showListNode(rs);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode cur=fake;
        while (cur!=null){
            ListNode next=cur.next;
            if(next!=null && next.val==val){
                cur.next=next.next;
            }else{
                cur=cur.next;
            }
        }
        return fake.next;
    }
}
