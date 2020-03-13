package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1295. 统计位数为偶数的数字
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 *
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * 通过次数13,433提交次数16,335
 * 在真实的面试中遇到过这道题？
 * */
public class FindNumbersWithEvenNumberOfDigits {

    @Test
    public void test(){
        Assert.assertEquals(2,findNumbers(new int[]{12,345,2,6,7896}));
        Assert.assertEquals(1,findNumbers(new int[]{555,901,482,1771}));
    }

    public int findNumbers(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum=0;
        for(int num:nums){
            if(isEven(num)){
                sum++;
            }
        }
        return sum;

    }

    private boolean isEven(int num){
        int sum=(int)Math.log10(num)+1;
        if(sum%2==0){
            return true;
        }
        return false;
    }

//    private boolean isEven(int num){
//        int sum=1;
//        while ((num=num/10)>0){
//            sum++;
//        }
//        if(sum%2==0){
//            return true;
//        }
//        return false;
//    }
}
