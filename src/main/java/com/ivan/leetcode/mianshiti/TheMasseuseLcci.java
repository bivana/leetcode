package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * 通过次数25,044提交次数46,762
 * */
public class TheMasseuseLcci {

    @Test
    public void test(){
        Assert.assertEquals(4,massage(new int[]{1,2,3,1}));
        Assert.assertEquals(12,massage(new int[]{2,7,9,3,1}));
        Assert.assertEquals(12,massage(new int[]{2,1,4,5,3,1,1,3}));
    }

    public int massage(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max2=0;
        int max1=0;
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            max=Math.max(nums[i]+max2,max1);
            max2=max1;
            max1=max;
        }
        return max;
    }

    public int massage(int[] nums,int start){
        if(start>=nums.length){
            return 0;
        }
        int v1=nums[start]+massage(nums,start+2);
        int v2=massage(nums,start+1);
        return Math.max(v1,v2);
    }
}
