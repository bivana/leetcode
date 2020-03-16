package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 * */
public class JumpGame2 {

    @Test
    public void test(){
        Assert.assertEquals(0,jump(new int[]{0}));
        Assert.assertEquals(2,jump(new int[]{2,3,1,1,4}));
    }

    /**
     * 动态规划
     * */
    public int jum2(int[] nums) {
        int end=0;
        int maxPosition=0;
        int steps=0;
        for(int i=0;i<nums.length-1;i++){
            //下一次最远能到达的距离
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //本次轮询完毕
            if(i==end){
                //下一次最远的距离
                end=maxPosition;
                steps++;
                if(maxPosition>=nums.length-1){
                    return steps;
                }
            }
        }
        return 0;
    }

    public int jump(int[] nums) {
        int steps=0;
        int position=nums.length-1;
        while (position!=0){
            for(int i=0;i<position;i++){
                if(nums[i]>=position-i){
                    position=i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

}
