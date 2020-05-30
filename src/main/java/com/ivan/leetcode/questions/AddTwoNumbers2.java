package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.Stack;

/**
 *
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 通过次数37,203提交次数64,976
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class AddTwoNumbers2 {

    @Test
    public void test(){
        ListNode l1=new ListNode(7);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        ListNode l4=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        ListNode t1=new ListNode(5);
        ListNode t2=new ListNode(6);
        ListNode t3=new ListNode(4);
        t1.next=t2;
        t2.next=t3;

        ListNode listNode=addTwoNumbers(l1,t1);
        ShowUtil.showListNode(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int add=0;
        ListNode pre=null;
        while (!stack1.isEmpty()|| !stack2.isEmpty()){
            int val=(stack1.isEmpty()?0:stack1.pop())+(stack2.isEmpty()?0:stack2.pop())+add;
            if(val>=10){
                add=1;
            }else{
                add=0;
            }
            ListNode listNode=new ListNode(val%10);
            listNode.next=pre;
            pre=listNode;
        }
        if(add!=0){
            ListNode listNode=new ListNode(add);
            listNode.next=pre;
            pre=listNode;
        }
        return pre;
    }
}
