package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 * */
public class ShuZuZhongShuZiChuXianDeCiShuLcof {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2,10},singleNumbers(new int[]{1,2,10,4,1,4,3,3}));
        Assert.assertArrayEquals(new int[]{6,1},singleNumbers(new int[]{4,1,4,6}));
    }

    public int[] singleNumbers(int[] nums) {
        int res=0;
        for(int num:nums){
            res^=num;
        }
        int pos=1;
        while((res&pos)!=pos){
            pos=pos<<1;
        }
        int[] ans=new int[2];
        for(int num:nums){
            if((num&pos)==pos){
                ans[1]^=num;
            }else{
                ans[0]^=num;
            }
        }
        return ans;
    }
}
