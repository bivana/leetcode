package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 155. 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * */
public class MinStack {

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3,minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0,minStack.top());
        Assert.assertEquals(-2,minStack.getMin());
    }

    int pos=-1;


    int[] array=new int[10];

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

        //扩容检查
        if(pos==array.length-1){
            int[] newArray=new int[array.length*2];
            System.arraycopy(array,0,newArray,0,array.length);
            array=newArray;
        }
        array[++pos]=x;
    }

    public void pop() {
        if(pos>=0){
            pos--;
        }
    }

    public int top() {
        return array[pos];
    }

    public int getMin() {
        if(pos<0){
            throw new RuntimeException("数据为空");
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=pos;i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }
}
