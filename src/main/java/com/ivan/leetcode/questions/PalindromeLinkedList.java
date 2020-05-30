package com.ivan.leetcode.questions;

import com.ivan.leetcode.questions.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * */
public class PalindromeLinkedList {

    @Test
    public void test(){
//        Assert.assertEquals(false,isPalindrome(ListNode.create(2)));
        Assert.assertEquals(false,isPalindrome(ListNode.create(4)));
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        l1.next=l2;
        ListNode l3=new ListNode(2);
        l2.next=l3;
        ListNode l4=new ListNode(1);
        l3.next=l4;
        Assert.assertEquals(true,isPalindrome(l1));

        ListNode i1=new ListNode(1);
        ListNode i2=new ListNode(2);
        i1.next=i2;
        ListNode i3=new ListNode(1);
        i2.next=i3;
        ListNode i4=new ListNode(2);
        i3.next=i4;
        ListNode i5=new ListNode(1);
        i4.next=i5;
        Assert.assertEquals(true,isPalindrome(i1));
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        //用于反转前面的node
        ListNode pre=slow;
        ListNode nextSlow=slow.next;
        while (fast!=null && fast.next!=null){
            pre=slow;
            slow=nextSlow;
            nextSlow=slow.next;
            fast=fast.next.next;
            //翻转slow前的列表
            slow.next=pre;
            head.next=null;
        }
        //奇数
        if(fast==null){
            return compare(slow.next,nextSlow);
        }else{
            //偶数
            return compare(slow,nextSlow);
        }
    }

    private boolean compare(ListNode l1,ListNode l2){
        while (l1!=null&&l2!=null){
            if(l1.val!=l2.val){
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
}
