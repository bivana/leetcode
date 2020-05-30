package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.questions.ListNode;
import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * 通过次数19,691提交次数33,142
 * */
public class ShanChuLianBiaoDeJieDianLcof {

    @Test
    public void test(){
        ListNode l1=deleteNode(ListNode.create(new int[]{4,5,1,9}),5);
        ShowUtil.showListNode(l1);
        System.out.println("========");
        ListNode l2=deleteNode(ListNode.create(new int[]{4,5,1,9}),1);
        ShowUtil.showListNode(l2);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode pre=fake;
        ListNode cur=fake.next;
        while (cur!=null){
            if(val==cur.val){
                pre.next=cur.next;
                break;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return fake.next;
    }
}
