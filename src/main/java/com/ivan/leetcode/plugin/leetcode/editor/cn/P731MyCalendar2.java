package com.ivan.leetcode.plugin.leetcode.editor.cn;

//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
//
// MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里
//的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end。 
//
// 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。 
//
// 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该
//日程安排添加到日历中。 
//
// 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(
//start, end) 
//
// 
//
// 示例： 
//
// MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(50, 60); // returns true
//MyCalendar.book(10, 40); // returns true
//MyCalendar.book(5, 15); // returns false
//MyCalendar.book(5, 10); // returns true
//MyCalendar.book(25, 55); // returns true
//解释： 
//前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
//第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
//第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
//第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
//时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
// 
//
// 
//
// 提示： 
//
// 
// 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。 
// 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。 
// 
// Related Topics 设计 线段树 二分查找 有序集合 👍 140 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P731MyCalendar2 {

    @Test
    public void test(){
        MyCalendarTwo my=new MyCalendarTwo();
        Assert.assertEquals(true,my.book(10,20));
        Assert.assertEquals(true,my.book(50,60));
        Assert.assertEquals(true,my.book(10,40));
        Assert.assertEquals(false,my.book(5,15));
        Assert.assertEquals(true,my.book(5,10));
        Assert.assertEquals(true,my.book(25,55));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarTwo {

        SegmentTreeNode segmentTreeNode;

        public MyCalendarTwo() {
            segmentTreeNode=new SegmentTreeNode(0,(int)1e9);
        }

        public boolean book(int start, int end) {
            int ans=segmentTreeNode.query(segmentTreeNode,start,end-1);
            if(ans>=2){
                return false;
            }
            segmentTreeNode.update(segmentTreeNode,start,end-1,1);
            return true;
        }
    }

    class SegmentTreeNode{
        int left;//左边界
        int right;//右边界
        int val; //值
        int lazy; //懒惰标记
        SegmentTreeNode leftNode;
        SegmentTreeNode rightNode;

        public SegmentTreeNode(int left,int right){
            this.left=left;
            this.right=right;
        }

        /**
         * 区间更新
         * */
        public void update(SegmentTreeNode root,int left,int right,int val){
            //不在区间范围
            if(root.left>right||root.right<left){
                return;
            }
            //懒惰标记
            if(root.left>=left&&root.right<=right){
                root.lazy+=val;
                root.val+=val;
            }else{
                //动态开点
                dynamicCreate(root);
                //懒节点下推
                pushDown(root);
                //更新左节点
                update(root.leftNode,left,right,val);
                //更新右节点
                update(root.rightNode,left,right,val);
                pushUp(root);
            }
        }

        public int query(SegmentTreeNode root,int left,int right){
            if(root.left>= left&&root.right<= right){
                return root.val;
            }
            dynamicCreate(root);
            pushDown(root);
            int mid=root.left+(root.right-root.left)/2;
            if(right<=mid){
                return query(root.leftNode,left,right);
            }else if(left>mid){
                return query(root.rightNode,left,right);
            }else{
                return Math.max(query(root.leftNode,left,mid),query(root.rightNode,mid+1,right));
            }
        }

        private void pushUp(SegmentTreeNode root) {
            root.val=Math.max(root.leftNode.val,root.rightNode.val);
        }

        private void pushDown(SegmentTreeNode root) {
            if(root.lazy==0){
                return;
            }
            root.leftNode.lazy+=root.lazy;
            root.rightNode.lazy+=root.lazy;
            root.leftNode.val+=root.lazy;
            root.rightNode.val+=root.lazy;
            root.lazy=0;
        }

        private void dynamicCreate(SegmentTreeNode root) {
           if(root.leftNode==null){
                root.leftNode=new SegmentTreeNode(root.left,root.left+(root.right-root.left)/2);
            }
            if(root.rightNode==null){
                root.rightNode=new SegmentTreeNode(root.left+(root.right-root.left)/2+1,root.right);
            }
        }
    }



    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}

