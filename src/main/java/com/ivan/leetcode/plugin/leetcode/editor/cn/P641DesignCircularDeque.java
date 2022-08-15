package com.ivan.leetcode.plugin.leetcode.editor.cn;//设计实现双端队列。
// 641. 设计循环双端队列
// 实现 MyCircularDeque 类: 
//
// 
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。 
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。 
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。 
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。 
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。 
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。 
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。 
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。 
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次 
// 
//
// Related Topics 设计 队列 数组 链表 👍 154 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P641DesignCircularDeque{

    @Test
    public void test(){
//        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//        Assert.assertEquals(true,circularDeque.insertLast(1));// 返回 true
//        Assert.assertEquals(true,circularDeque.insertLast(2));// 返回 true
//        Assert.assertEquals(true,circularDeque.insertFront(3));	// 返回 true
//        Assert.assertEquals(false,circularDeque.insertFront(4));// 已经满了，返回 false
//        Assert.assertEquals(2,circularDeque.getRear());// 返回 2
//        Assert.assertEquals(true,circularDeque.isFull());// 返回 true
//        Assert.assertEquals(true,circularDeque.deleteLast());// 返回 true
//        Assert.assertEquals(true,circularDeque.insertFront(4));// 返回 true
//        Assert.assertEquals(4,circularDeque.getFront());				// 返回 4


        MyCircularDeque circularDeque = new MyCircularDeque(41); // 设置容量大小为3
        Assert.assertEquals(true,circularDeque.insertFront(70));// 返回 true
        Assert.assertEquals(true,circularDeque.insertLast(11));// 返回 true
        Assert.assertEquals(11,circularDeque.getRear());	// 返回 true
        Assert.assertEquals(70,circularDeque.getFront());// 已经满了，返回 false
        Assert.assertEquals(70,circularDeque.getFront());// 已经满了，返回 false
        Assert.assertEquals(true,circularDeque.deleteLast());// 返回 true
        Assert.assertEquals(true,circularDeque.deleteFront());// 返回 true
        Assert.assertEquals(-1,circularDeque.getRear());// 返回 true
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Node{
        int val;
        Node next;
        Node pre;

        public Node(int val){
            this.val=val;
        }
    }
    class MyCircularDeque {

        Node head;
        Node tail;

        int capacity;

        int size=0;

        public MyCircularDeque(int k) {
            capacity=k;
        }

        public boolean insertFront(int value) {
            if(size>=capacity){
                return false;
            }
            Node node=new Node(value);
            if(head!=null){
                node.next=head;
                head.pre=node;
            }
            head=node;
            if(tail==null){
                tail=node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(size>=capacity){
                return false;
            }
            Node node=new Node(value);
            if(tail!=null){
                node.pre=tail;
                tail.next=node;
            }
            tail=node;
            if(head==null){
                head=node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(head==null){
                return false;
            }
            head=head.next;
            if(head==null){
                tail=null;
            }else{
                head.pre=null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(tail==null){
                return false;
            }
            tail=tail.pre;
            if(tail==null){
                head=null;
            }else{
                tail.next=null;
            }
            size--;
            return true;
        }

        public int getFront() {
            if(head==null){
                return -1;
            }
            return head.val;
        }

        public int getRear() {
            if(tail==null){
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size>=capacity;
        }
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}