package com.ivan.leetcode;

import java.util.List;

/**
 *  19. 删除链表的倒数第N个节点
 *
 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * */
public class RemoveNthFromEnd {

    public static void main(String[] args){
        RemoveNthFromEnd removeNthFromEnd=new RemoveNthFromEnd();
        removeNthFromEnd.test();

    }

    public void test(){
//        ListNode l1=new ListNode(1);
//        ListNode l2=new ListNode(2);
//        l1.next=l2;
//        ListNode l3=new ListNode(3);
//        l2.next=l3;
//        ListNode l4=new ListNode(4);
//        l3.next=l4;
//        ListNode l5=new ListNode(5);
//        l4.next=l5;
        ListNode l1=new ListNode(1);
//        ListNode l2=new ListNode(2);
//        l1.next=l2;
        ListNode result=removeNthFromEnd(l1,1);

        ListNode temp;
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public  class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastNAdd1=null;//倒数n+1 删除倒数n需要操作倒数n+1节点
        int i=1;
        ListNode temp=head;
        while (temp!=null){

            if(i==n+1){
                lastNAdd1=head;
            }else if(i>n+1){
                lastNAdd1=lastNAdd1.next;
            }
            temp=temp.next;
            i++;
        }
        //倒数N=1为空，表示删除的是头结点
        if(lastNAdd1==null){
            return head.next;
        }else if (lastNAdd1.next!=null){
            lastNAdd1.next=lastNAdd1.next.next;
        }else{
            return null;
        }

        return head;
    }
}
