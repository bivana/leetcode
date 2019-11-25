package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * */
public class JumpGame {

    @Test
    public void test(){
        Assert.assertEquals(true,canJump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(false,canJump(new int[]{3,2,1,0,4}));
    }


    /**
     * 贪心
     * */
    public boolean canJump(int[] nums) {
        if(nums.length==0){
            return false;
        }
        int last=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=last){
                last=i;
            }
        }
        return last==0;
    }

    /**
     * 动态规划
     * */
    public boolean canJump2(int[] nums) {
        if(nums.length==0){
            return false;
        }
        Boolean[] rs=new Boolean[nums.length];
        return canJump(nums,0,rs);
    }

    public boolean canJump(int[] nums,int i,Boolean[] rs){
        if(rs[i]!=null){
            return rs[i];
        }
        if(i+nums[i]>=nums.length-1){
            return true;
        }
        for(int j=Math.min(nums.length-1,i+nums[i]);j>=i+1;j--){
            if(canJump(nums,j,rs)){
                return true;
            }
        }
        rs[i]=false;
        return rs[i];
    }
}
