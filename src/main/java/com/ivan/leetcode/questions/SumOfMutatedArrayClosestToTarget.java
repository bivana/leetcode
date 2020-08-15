package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 *
 * 请注意，答案不一定是 arr 中的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 *
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 *
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * */
public class SumOfMutatedArrayClosestToTarget {

    @Test
    public void test(){
        Assert.assertEquals(17422,findBestValue(new int[]{1547,83230,57084,93444,70879},71237));
        Assert.assertEquals(3,findBestValue(new int[]{4,9,3},10));
        Assert.assertEquals(5,findBestValue(new int[]{2,3,5},10));
        Assert.assertEquals(11361,findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        return findBestValue(arr,target,0);
    }

    public int findBestValue(int[] arr,int target,int start){
        int len=arr.length-start;
        double expect=(double)target/len;
        int i=start;
        int lessSum=0;Double d=0.0;
        while (i<arr.length&&arr[i]<=expect){
            lessSum+=arr[i];
            i++;
        }
        //数字全都大于预期数
        if(i==start){
            int floorExpect=(int)Math.floor(expect);
            int cellExpect=(int)Math.ceil(expect);
            int floorInter=Math.abs(target-floorExpect*len);
            int cellInter=Math.abs(target-cellExpect*len);
            return floorInter<=cellInter?floorExpect:cellExpect;
        }else if(i==arr.length){
            //全都小于预期数
            return arr[arr.length-1];
        }
        return findBestValue(arr,target-lessSum,i);
    }
}
