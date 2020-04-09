package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * */
public class PartitionArrayIntoThreePartsWithEqualSum {

    @Test
    public void test(){
        Assert.assertEquals(true,canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        Assert.assertEquals(false,canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        Assert.assertEquals(true,canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));

    }


    public boolean canThreePartsEqualSum(int[] A) {
        if(A==null||A.length<3){
            return false;
        }
        int end=A.length-1;
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%3!=0){
            return false;
        }
        int target=sum/3;
        int left=1;
        int right=A.length-2;
        int leftSum=A[left-1];
        while (leftSum!=target && left<=right){
            leftSum+=A[left++];
        }
        if(left>right){
            return false;
        }
        int rightTarget=A[right+1];
        while (rightTarget!=target && left<=right){
            rightTarget+=A[right--];
        }
        if(left>right){
            return false;
        }
        int midSum=0;
        for(int i=left;i<=right;i++){
            midSum+=A[i];
        }
        if(midSum!=target){
            return false;
        }
        return true;


    }
}
