package com.ivan.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * */
public class MergeKSortedLists {


    @Test
    public void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(5);
        l1.next=l2;
        l2.next=l3;

        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(3);
        ListNode a3=new ListNode(4);
        a1.next=a2;
        a2.next=a3;

        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(6);
        b1.next=b2;

//        ListNode result=mergeKLists(new ListNode[]{l1,a1,b1});
        ListNode result=mergeKLists(new ListNode[]{});

        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(0);
        ListNode temp=result;
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length+1, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if(o1==null && o2==null){
                    return 0;
                }else if(o1!=null && o2!=null){
                    if(o1.val==o2.val){
                        return 0;
                    }else if(o1.val>o2.val){
                        return 1;
                    }else{
                        return -1;
                    }
                }else if(o1!=null){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        ListNode top=null;
        while ((top=queue.poll())!=null){
            temp.next=top;
            temp=temp.next;
            if(top.next!=null){
                queue.add(top.next);
            }
        }
        return result.next;
    }



    private boolean isNull(ListNode[] lists){
        boolean isNull=true;
        for(ListNode listNode:lists){
            if(listNode!=null){
                return false;
            }
        }
        return isNull;
    }
}
