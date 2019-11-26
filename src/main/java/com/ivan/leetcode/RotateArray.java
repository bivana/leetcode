package com.ivan.leetcode;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 189. 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * */
public class RotateArray {

    @Test
    public void test(){
//        rotate(new int[]{1,2,3,4,5,6},2);
//
        int[] array=new int[]{1,2,3,4,5,6,7};
        rotate(array,3);
        ShowUtil.showIntArray(array);
        Assert.assertArrayEquals(new int[]{5,6,7,1,2,3,4},array);

        array=new int[]{-1,-100,3,99};
        rotate(array,2);
        Assert.assertArrayEquals(new int[]{3,99,-1,-100},array);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count=0;
        for(int start=0;count<nums.length;start++){
            int curIndex=start;
            int preValue=nums[curIndex];
            do{
                curIndex=(curIndex+k)%nums.length;
                int temp=nums[curIndex];
                nums[curIndex]=preValue;
                preValue=temp;
                count++;

            }while (start!=curIndex);
        }
    }
}
