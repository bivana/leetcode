package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * */
public class SortColors {

    @Test
    public void test(){
        int[] a=new int[]{2,0,2,1,1,0};
        sortColors(a);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2},a);

        int[] b=new int[]{2,0,1};
        sortColors(b);
        Assert.assertArrayEquals(new int[]{0,1,2},b);
    }

    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int start=0;
        int end=nums.length-1;
        int i=0;
        while (i<=end){
            if(nums[i]==0){
                replace(nums,i,start);
                start++;
                i++;
            }else if(nums[i]==2){
                replace(nums,i,end);
                end--;
            }else{
                i++;
            }
        }

    }

    private void replace(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
