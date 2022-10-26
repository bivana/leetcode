package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 862
// 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 523 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class P862ShortestSubarrayWithSumAtLeastK{

    public Solution solution=new Solution();

    @Test
    public void test(){
//        Assert.assertEquals(1,solution.shortestSubarray(new int[]{1},1));
//        Assert.assertEquals(-1,solution.shortestSubarray(new int[]{1,2},4));
        Assert.assertEquals(3,solution.shortestSubarray(new int[]{2,-1,2},3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            long[] pre=new long[nums.length+1];
            for(int i=0;i<nums.length;i++){
                pre[i+1]=pre[i]+nums[i];
            }
            int res=nums.length+1;
            Deque<Integer> deque=new ArrayDeque<>();
            for(int i=0;i<pre.length;i++){
                long curSum=pre[i];
                //如果第一个满足，后面就不用看了，后面满足条件只会更长
                while (!deque.isEmpty()&&curSum-pre[deque.peekFirst()]>=k){
                    res=Math.min(res,i-deque.pollFirst());
                }
                //如果最后一个比当前大，那么也不用看了
                while (!deque.isEmpty()&&pre[deque.peekLast()]>=curSum){
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return res<=nums.length?res:-1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}


