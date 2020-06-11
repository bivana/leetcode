package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * */
public class TiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,3,4,2},exchange(new int[]{1,2,3,4}));

    }

    public int[] exchange(int[] nums) {
        if(nums==null){
            return nums;
        }
        int start=0;
        int end=nums.length-1;
        while (start<end){
            if((nums[start]&1)==1){
                start++;
            }else{
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                end--;
            }
        }
        return nums;
    }
}
