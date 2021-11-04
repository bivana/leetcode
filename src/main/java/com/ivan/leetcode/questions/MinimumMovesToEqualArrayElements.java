package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 * */
public class MinimumMovesToEqualArrayElements {

    @Test
    public void test(){
        Assert.assertEquals(1000000,minMoves(new int[]{1,1,1000000000}));
        Assert.assertEquals(3,minMoves(new int[]{1,2,3}));
        Assert.assertEquals(0,minMoves(new int[]{1,1,1}));
    }

    /**减法*/
//    public int minMoves(int[] nums) {
//        if(nums==null||nums.length<=1){
//            return 0;
//        }
//        int min=nums[0];
//        int len=1;
//        int ans=0;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]<min){
//                ans+=(min-nums[i])*len;
//                min=nums[i];
//            }else{
//                ans+=nums[i]-min;
//            }
//            len++;
//        }
//        return ans;
//    }

    //加法
    public int minMoves(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int ans=0;
        int lst=nums.length-1;
        while (nums[0]!=nums[lst]){
            // n-1  个数字 +1
            for(int i=0;i<lst;i++){
                nums[i]=nums[i]+1;
            }
            // 冒泡比较
            for(int i=lst-1;i>=0;i--){
                if(nums[i]>nums[i+1]){
                    int tmp=nums[i+1];
                    nums[i+1]=nums[i];
                    nums[i]=tmp;
                }else{
                    break;
                }
            }
            ans++;

        }
        return ans;
    }
}
