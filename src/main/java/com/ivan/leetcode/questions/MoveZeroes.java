package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * */
public class MoveZeroes {

    @Test
    public void test(){
        int[] nums;
        nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1,3,12,0,0},nums);
        nums=new int[]{0,0,1};
        moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1,0,0},nums);

    }

    public void moveZeroes(int[] nums) {
        int i=0;
        for(int l=0;l<nums.length;l++){
            if(nums[l]!=0){
                nums[i++]=nums[l];
            }
        }
        for(int l=i;l<nums.length;l++){
            nums[l]=0;
        }

    }
}
