package com.ivan.leetcode.questions;

import org.junit.Test;

import java.util.Random;

/**
 * 382. 链表随机节点
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 *
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *
 *
 * 示例：
 *
 *
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 *
 *
 * 提示：
 *
 * 链表中的节点数在范围 [1, 104] 内
 * -104 <= Node.val <= 104
 * 至多调用 getRandom 方法 104 次
 * */
public class LinkedListRandomNode {

    @Test
    public void test(){
        Solution solution=new Solution(ListNode.create(new int[]{1,2,3}));
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    class Solution {

        private ListNode head;

        private Random rand=new Random();

        public Solution(ListNode head) {
            this.head=head;
        }

        public int getRandom() {
            ListNode cur=head;
            int ans=cur.val;
            int index=1;
            while (cur!=null&&index>0){
                if(rand.nextInt(index)==0){
                    ans=cur.val;
                }
                index++;
                cur=cur.next;
            }
            return ans;
        }
    }
}
