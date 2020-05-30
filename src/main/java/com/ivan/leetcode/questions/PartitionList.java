package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 通过次数36,164提交次数62,807
 * 在真实的面试中遇到过这道题？
 * */
public class PartitionList {

    @Test
    public void test(){
        ListNode listNode=partition(ListNode.create(new int[]{1,4,3,2,5,2}),3);
        ShowUtil.showListNode(listNode);
    }

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode S=new ListNode(-1);
        ListNode B=new ListNode(-1);
        ListNode small=S;
        ListNode big=B;
        while (head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }else{
                big.next=head;
                big=big.next;
            }
            head=head.next;
        }
        small.next=B.next;
        big.next=null;
        return S.next;

    }
}
