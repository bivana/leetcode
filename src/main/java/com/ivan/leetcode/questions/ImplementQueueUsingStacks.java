package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 通过次数35,086提交次数55,407
 *
 * */
public class ImplementQueueUsingStacks {

    @Test
    public void test(){
        MyQueue myQueue=new MyQueue();
        Assert.assertEquals(true,myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        Assert.assertEquals(1,myQueue.peek());
        Assert.assertEquals(false,myQueue.empty());
        Assert.assertEquals(1,myQueue.pop());
        Assert.assertEquals(false,myQueue.empty());
        Assert.assertEquals(2,myQueue.pop());
        Assert.assertEquals(true,myQueue.empty());
    }

    class MyQueue {

        Stack<Integer> stack;
        Stack<Integer> reverse;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack=new Stack<>();
            reverse=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        private void check(){
            if(reverse.isEmpty() && !stack.isEmpty()){
                synchronized (this){
                    while (!stack.isEmpty()){
                        reverse.push(stack.pop());
                    }
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            check();
            return reverse.pop();
        }

        /** Get the front element. */
        public int peek() {
            check();
            return reverse.peek();

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.empty() && reverse.empty();
        }
    }
}
