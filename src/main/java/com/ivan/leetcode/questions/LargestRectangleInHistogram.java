package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 通过次数47,029提交次数119,160
 * */
public class LargestRectangleInHistogram {

    @Test
    public void test(){
        Assert.assertEquals(10,largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                System.out.println(">>>>>>>>>>");
                System.out.println(i);
                System.out.println("l:"+l+" r:"+r+" height:"+new_heights[cur]);
                System.out.println((r - l - 1) * new_heights[cur]);
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

}
