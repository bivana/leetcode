package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * */
public class TrappingRainWater {

    @Test
    public void test(){
        Assert.assertEquals(6,trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * 双指针，由动态规划优化而来
     * */
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int sum=0;
        int maxLeft=height[0];
        int maxRight=height[height.length-1];
        int left=1;
        int right=height.length-2;
        while (left<=right){
            if(maxLeft<=maxRight){
                sum=sum+(maxLeft-height[left]>0?maxLeft-height[left]:0);
                maxLeft=Math.max(maxLeft,height[left]);
                left++;
            }else{
                sum=sum+(maxRight-height[right]>0?maxRight-height[right]:0);
                maxRight=Math.max(maxRight,height[right]);
                right--;
            }
        }
        return sum;
    }

    /**
     * 最基础的解法，按列计算，求列的坐左边和最右边最高，计算该列应该存储水多少
     * 时间复杂度 ON2
     * */
    public int trapBase(int[] height) {
        int totalTrap=0;
        for(int i=1;i<height.length-1;i++){
            int left=i-1;
            while (left-1>=0 && height[left-1]>height[left]){
                left--;
            }
            int right=i+1;
            while (right+1<height.length && height[right+1]>height[right]){
                right++;
            }
            int maxHeight=Math.min(height[left],height[right]);
            if(maxHeight>height[i]){
                totalTrap=totalTrap+(maxHeight-height[i]);
            }
        }
        return totalTrap;
    }
}
