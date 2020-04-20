package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * 通过次数20,014提交次数40,983
 * */
public class DuiLieDeZuiDaZhiLcof {

    @Test
    public void test(){
        MaxQueue queue=new MaxQueue();
//        queue.push_back(1);
//        queue.push_back(2);
//        Assert.assertEquals(2,queue.max_value());
//        Assert.assertEquals(1,queue.pop_front());
//        Assert.assertEquals(2,queue.max_value());
        queue.push_back(837);
        System.out.println(queue.max_value());
        queue.push_back(812);
        System.out.println(queue.max_value());
        queue.pop_front();
        System.out.println(queue.max_value());
    }

    class MaxQueue {

        private Queue<Integer> queue=new ArrayDeque<>();

        private Deque<Integer> max=new ArrayDeque<>();

        public MaxQueue() {

        }

        public int max_value() {
            if(max.isEmpty()){
                return -1;
            }
            return max.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!max.isEmpty() && max.peekLast()<value){
                max.pollLast();
            }
            max.add(value);
        }

        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }
            int i=queue.poll();
            if(!max.isEmpty() && i==max.peek()){
                max.poll();
            }
            return i;
        }
    }
}
