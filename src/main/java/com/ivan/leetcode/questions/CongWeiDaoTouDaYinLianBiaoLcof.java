package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 通过次数8,872提交次数11,450
 * */
public class CongWeiDaoTouDaYinLianBiaoLcof {

    @Test
    public void test(){
        ListNode l1=ListNode.create(new int[]{1,3,2});
        Assert.assertArrayEquals(new int[]{2,3,1},reversePrint(l1));
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> rs=new ArrayList<>();
        helper(head,rs);
        int[] array=new int[rs.size()];
        for(int i=0;i<rs.size();i++){
            array[i]=rs.get(i);
        }
        return array;
    }

    public void helper(ListNode head,List<Integer> rs){
        if(head==null){
            return;
        }
        if(head.next!=null){
            helper(head.next,rs);
        }
        rs.add(head.val);
    }
}
