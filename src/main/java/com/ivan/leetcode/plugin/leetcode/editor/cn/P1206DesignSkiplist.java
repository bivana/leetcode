package com.ivan.leetcode.plugin.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 1206. 设计跳表
 * 不使用任何库函数，设计一个 跳表 。
 *
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 *
 *
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 *
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 *
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 *
 * 在本题中，你的设计应该要包含这些函数：
 *
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 *
 *
 *
 * 示例 1:
 *
 * 输入
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * 输出
 * [null, null, null, null, false, null, true, false, true, false]
 *
 * 解释
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 *
 *
 * 提示:
 *
 * 0 <= num, target <= 2 * 104
 * 调用search, add,  erase操作次数不大于 5 * 104
 * */
public class P1206DesignSkiplist {

    @Test
    public void test(){
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        Assert.assertEquals(false,skiplist.search(0));   // 返回 false
        skiplist.add(4);
        Assert.assertEquals(true,skiplist.search(1));   // 返回 true
        Assert.assertEquals(false,skiplist.erase(0));;    // 返回 false，0 不在跳表中
        Assert.assertEquals(true,skiplist.erase(1));    // 返回 true
        Assert.assertEquals(false,skiplist.search(1));   // 返回 false，1 已被擦除
    }

    class Skiplist {

        private SkipNode head;

        private int MAX_LEVEL=32;//最大层数
        private double P_FACTOR=0.25;//每层概率
        private Random random;

        private int curLevel;

        public Skiplist() {
            this.head=new SkipNode(-1,MAX_LEVEL);
            this.curLevel=1;
            this.random=new Random();
        }

        public boolean search(int target) {
            SkipNode search=head;
            for(int i=curLevel-1;i>=0;i--){
                search=findClosetNode(search,i,target);
                if(search.next[i]!=null&&search.next[i].val==target){
                    return true;
                }
            }
            return false;
        }

        public void add(int num) {
            int level=getRandLevel();
            SkipNode update=head;
            SkipNode newNode=new SkipNode(num,level);
            // 计算出当前num 索引的实际层数，从该层开始添加索引
            for(int i=curLevel-1;i>=0;i--){
                update=findClosetNode(update,i,num);
                if(i<level){//在当前层内
                    if(update.next[i]==null){
                        update.next[i]=newNode;
                    }else{
                        SkipNode tmp=update.next[i];
                        update.next[i]=newNode;
                        newNode.next[i]=tmp;
                    }

                }
            }
            if(level>curLevel){//如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
                for(int i=curLevel;i<level;i++){
                    head.next[i]=newNode;
                }
                curLevel=level;
            }

        }

        public boolean erase(int num) {
            SkipNode search=head;
            boolean rs=false;
            for(int i=curLevel-1;i>=0;i--){
                search=findClosetNode(search,i,num);
                if(search.next[i]!=null&&search.next[i].val==num){
                    search.next[i]=search.next[i].next[i];
                    rs=true;
                    continue;
                }
            }
            return rs;
        }

        public SkipNode findClosetNode(SkipNode searchNode,int level,int val){
            while (searchNode.next[level]!=null&&searchNode.next[level].val<val){
                searchNode=searchNode.next[level];
            }
            return searchNode;
        }

        public int getRandLevel(){
            int level=1;
            while (Math.random()<P_FACTOR&&level<MAX_LEVEL){
                level++;
            }
            return level;
        }
    }

    class SkipNode{
        int val;
        SkipNode[] next;

        public SkipNode(int val,int size){
            this.val=val;
            this.next=new SkipNode[size];
        }
    }

//    class Skiplist {
//        /**
//         * 最大层数
//         */
//        private  int DEFAULT_MAX_LEVEL = 32;
//        /**
//         * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
//         */
//        private  double DEFAULT_P_FACTOR = 0.25;
//
//        Node head = new Node(null,DEFAULT_MAX_LEVEL); //头节点
//
//        int currentLevel = 1; //表示当前nodes的实际层数，它从1开始
//
//
//        public Skiplist() {
//        }
//
//        public boolean search(int target) {
//            Node searchNode = head;
//            for (int i = currentLevel-1; i >=0; i--) {
//                searchNode = findClosest(searchNode, i, target);
//                if (searchNode.next[i]!=null && searchNode.next[i].value == target){
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        /**
//         *
//         * @param num
//         */
//        public void add(int num) {
//            int level = randomLevel();
//            Node updateNode = head;
//            Node newNode = new Node(num,level);
//            // 计算出当前num 索引的实际层数，从该层开始添加索引
//            for (int i = currentLevel-1; i>=0; i--) {
//                //找到本层最近离num最近的list
//                updateNode = findClosest(updateNode,i,num);
//                if (i<level){
//                    if (updateNode.next[i]==null){
//                        updateNode.next[i] = newNode;
//                    }else{
//                        Node temp = updateNode.next[i];
//                        updateNode.next[i] = newNode;
//                        newNode.next[i] = temp;
//                    }
//                }
//            }
//            if (level > currentLevel){ //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
//                for (int i = currentLevel; i < level; i++) {
//                    head.next[i] = newNode;
//                }
//                currentLevel = level;
//            }
//
//        }
//
//        public boolean erase(int num) {
//            boolean flag = false;
//            Node searchNode = head;
//            for (int i = currentLevel-1; i >=0; i--) {
//                searchNode = findClosest(searchNode, i, num);
//                if (searchNode.next[i]!=null && searchNode.next[i].value == num){
//                    //找到该层中该节点
//                    searchNode.next[i] = searchNode.next[i].next[i];
//                    flag = true;
//                    continue;
//                }
//            }
//            return flag;
//        }
//
//        /**
//         * 找到level层 value 大于node 的节点
//         * @param node
//         * @param levelIndex
//         * @param value
//         * @return
//         */
//        private Node findClosest(Node node,int levelIndex,int value){
//            while ((node.next[levelIndex])!=null && value >node.next[levelIndex].value){
//                node = node.next[levelIndex];
//            }
//            return node;
//        }
//
//
//        /**
//         * 随机一个层数
//         */
//        private  int randomLevel(){
//            int level = 1;
//            while (Math.random()<DEFAULT_P_FACTOR && level<DEFAULT_MAX_LEVEL){
//                level ++ ;
//            }
//            return level;
//        }
//
//
//        class Node{
//            Integer value;
//            Node[] next;
//
//            public Node(Integer value,int size) {
//                this.value = value;
//                this.next = new Node[size];
//            }
//
//            @Override
//            public String toString() {
//                return String.valueOf(value);
//            }
//        }
//
//    }



/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
}
