package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 148. 排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * */
public class SortList {

    @Test
    public void test(){
        ListNode l1=new ListNode(4);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode l=sortList(l1);
        ShowUtil.showListNode(l);

        ListNode t1=new ListNode(-1);
        ListNode t2=new ListNode(5);
        ListNode t3=new ListNode(3);
        ListNode t4=new ListNode(4);
        ListNode t5=new ListNode(0);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        ListNode t=sortList(t1);
        ShowUtil.showListNode(t);
    }

    public  ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int count=0;
        while (head!=null){
            count++;
            head=head.next;
        }



        for(int i=1;i<count;i=i<<1){
            ListNode cur=dummy.next;
            ListNode tail=dummy;
            while (cur!=null){
                ListNode left=cur;
                ListNode right=cut(cur,i);
                cur=cut(right,i);
                tail.next=merge(left,right);
                while (tail.next!=null){
                    tail=tail.next;
                }
            }
        }
        return dummy.next;
    }

    /**
     * 切到前n个节点
     *
     */
    public ListNode cut(ListNode listNode,int n){
        if(listNode==null){
            return null;
        }
        if(n<=0){
            return listNode;
        }
        while (--n>0 && listNode!=null){
            listNode=listNode.next;
        }
        if(listNode==null){
            return null;
        }
        ListNode next=listNode.next;
        listNode.next=null;
        return next;
    }

    /**
     * 将l1,l2两个node按顺序合并
     * */
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;
        return dummy.next;

    }
//    public ListNode sortList(ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode fast=head.next;
//        ListNode slow=head;
//        while (fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        ListNode left=head;
//        ListNode right=slow.next;
//        slow.next=null;
//        left=sortList(left);
//        right=sortList(right);
//        ListNode fake=new ListNode(-1);
//        ListNode temp=fake;
//        while (left!=null && right!=null){
//            if(left.val<right.val){
//                temp.next=left;
//                left=left.next;
//                temp=temp.next;
//            }else{
//                temp.next=right;
//                right=right.next;
//                temp=temp.next;
//            }
//        }
//        if(left!=null){
//            temp.next=left;
//        }
//        if(right!=null){
//            temp.next=right;
//        }
//        return fake.next;
//    }

//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode fast = head.next, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        ListNode h = new ListNode(0);
//        ListNode res = h;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                h.next = left;
//                left = left.next;
//            } else {
//                h.next = right;
//                right = right.next;
//            }
//            h = h.next;
//        }
//        h.next = left != null ? left : right;
//        return res.next;
//    }
}
