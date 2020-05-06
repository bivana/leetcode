package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.ListNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 *
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * */
public class FanZhuanLianBiaoLcof {

    @Test
    public void test(){
        ListNode listNode=reverseList(ListNode.create(5));
        ShowUtil.showListNode(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode last=head;
        while (last.next!=null){
            last=last.next;
        }
        ListNode fake=new ListNode(-1);
        ListNode cur=head;
        while (cur!=null ){
            ListNode temp=cur.next;
            cur.next=fake.next;
            fake.next=cur;
            cur=temp;
        }
        return fake.next;
    }
}
