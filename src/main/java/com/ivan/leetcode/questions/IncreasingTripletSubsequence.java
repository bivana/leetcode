package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * 5 4 3 1 2 0 4
 *
 *   5 3 1     4
 *
 *
 * 5,3,4，6，2,1
 * 5          1
 * */
public class IncreasingTripletSubsequence {

    @Test
    public void test(){
        Assert.assertEquals(true,increasingTriplet(new int[]{1,5,0,4,1,3}));
        Assert.assertEquals(true,increasingTriplet(new int[]{0,4,1,-1,2}));
        Assert.assertEquals(true,increasingTriplet(new int[]{1,2,3,4,5}));
        Assert.assertEquals(false,increasingTriplet(new int[]{5,4,3,2,1}));
        Assert.assertEquals(true,increasingTriplet(new int[]{2,1,5,0,4,6}));
    }

    public boolean increasingTriplet(int[] nums) {
        return (Boolean) increasingTriplet(nums,0,nums.length-1)[0];
    }

    public Object[] increasingTriplet(int[] nums,int l,int r) {
        if(r==l){
            return new Object[]{false,nums[l],nums[r]};
        }
        if(r-l==1){
            if(l<=r){
                return new Object[]{false,nums[l],nums[r]};
            }else{
                return new Object[]{false,nums[r],nums[l]};
            }
        }
        int mid=(l+r)>>1;
        Object[] lRs=increasingTriplet(nums,l,mid);
        if((Boolean) lRs[0]==true){
            return new Object[]{true,null,null};
        }
        Object[] rRs=increasingTriplet(nums,mid,r);
        if((Boolean) rRs[0]==true){
            return new Object[]{true,null,null};
        }
        if(nums[mid]>(Integer) lRs[1]&& nums[mid]<(Integer) rRs[2]){
            return new Object[]{true,null,null};
        }
        return new Object[]{false,Math.min(nums[mid],(Integer) lRs[1]),Math.max(nums[mid],(Integer) rRs[2])};
    }
}
