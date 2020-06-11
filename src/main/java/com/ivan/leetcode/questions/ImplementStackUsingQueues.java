package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * */
public class ImplementStackUsingQueues {

    @Test
    public void test(){

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        Assert.assertEquals(2,param_2);
        int param_3 = obj.top();
        Assert.assertEquals(1,param_3);
        boolean param_4 = obj.empty();
        Assert.assertEquals(false,param_4);
        obj.pop();
        Assert.assertEquals(true,obj.empty());

    }

    class MyStack {

        /**
         * 最优解为使用1个队列，不断出队列，再写入队列
         * */
        private Queue<Integer> queue=new ArrayDeque<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            int size=queue.size()-1;
            while (size-->0){
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

//    class MyStack {
//
//        /**
//         * 最优解为使用1个队列，不断出队列，再写入队列
//         * */
//        private Queue<Integer> queue1=new ArrayDeque<>();
//        private Queue<Integer> queue2=new ArrayDeque<>();
//
//        /** Initialize your data structure here. */
//        public MyStack() {
//
//        }
//
//        /** Push element x onto stack. */
//        public void push(int x) {
//            if(queue1.isEmpty()){
//                queue1.add(x);
//                while (!queue2.isEmpty()){
//                    queue1.add(queue2.poll());
//                }
//            }else{
//                queue2.add(x);
//                while (!queue1.isEmpty()){
//                    queue2.add(queue1.poll());
//                }
//            }
//        }
//
//        /** Removes the element on top of the stack and returns that element. */
//        public int pop() {
//            if(!queue1.isEmpty()){
//                return queue1.poll();
//            }else{
//                return queue2.poll();
//            }
//        }
//
//        /** Get the top element. */
//        public int top() {
//            if(!queue1.isEmpty()){
//                return queue1.peek();
//            }else{
//                return queue2.peek();
//            }
//        }
//
//        /** Returns whether the stack is empty. */
//        public boolean empty() {
//            return queue1.isEmpty()&&queue2.isEmpty();
//        }
//    }
}
