package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 通过次数24,489提交次数34,209
 * */
public class YongLiangGeZhanShiXianDuiLieLcof {

    @Test
    public void test(){
        CQueue cQueue=new CQueue();
        cQueue.appendTail(3);
        Assert.assertEquals(3,cQueue.deleteHead());
        Assert.assertEquals(-1,cQueue.deleteHead());
        Assert.assertEquals(-1,cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        Assert.assertEquals(5,cQueue.deleteHead());
        Assert.assertEquals(2,cQueue.deleteHead());
    }


    class CQueue {

        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> reverse=new Stack<Integer>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack.push(value);

        }

        public int deleteHead() {
            if(!reverse.isEmpty()){
                return reverse.pop();
            }
            if(!stack.isEmpty()){
                while (!stack.isEmpty()){
                    reverse.push(stack.pop());
                }
                return reverse.pop();
            }
            return -1;
        }
    }
}
