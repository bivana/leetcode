package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * */
public class HouseRobber {

    @Test
    public void test(){
        Assert.assertEquals(4,rob(new int[]{1,2,3,1}));
        Assert.assertEquals(12,rob(new int[]{2,7,9,3,1}));
    }

    /**
     * 官方题解
     * */
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    /**
     * 动态规划
     * f(1)=A1
     * f(2)=max(A1,A2)
     * f(3)=max(f(2),max(f1+3))
     * 所以有 f(x)=max(f(x-1),f(x-2)+Ax)
     * */
    public int rob2(int[] nums) {
        Integer[] temp=new Integer[nums.length];
        return rob(nums,nums.length-1,temp);
    }

    public int rob(int[] nums,int end,Integer[] temp){
        if(end<0){
            return 0;
        }else if(end==0){
            return nums[0];
        }else if(end==1){
            return Math.max(nums[0],nums[1]);
        }else{
            if(temp[end]==null){
                temp[end]=Math.max(rob(nums,end-1,temp),rob(nums,end-2,temp)+nums[end]);
            }
            return temp[end];
        }
    }
}
