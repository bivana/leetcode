package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 通过次数28,420提交次数60,458
 * */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    @Test
    public void test(){
        Assert.assertEquals(1,minArray(new int[]{3,4,5,1,2}));
        Assert.assertEquals(0,minArray(new int[]{2,2,2,0,1}));
    }

    //二分法
    public int minArray(int[] numbers) {
        int start=0;
        int end=numbers.length-1;
        while (start<end){
            int mid=(start+end)>>>1;
            if(numbers[mid]<numbers[end]){
                end=mid;
            }else if(numbers[mid]>numbers[end]){
                start=mid+1;
            }else{
                end--;
            }
        }
        return numbers[start];

    }

    //暴力法
    public int minArray2(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];

    }
}
