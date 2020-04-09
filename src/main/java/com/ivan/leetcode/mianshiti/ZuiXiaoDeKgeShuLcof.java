package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数41,519提交次数69,617
 * */
public class ZuiXiaoDeKgeShuLcof {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2,2,3},getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8));

        Assert.assertArrayEquals(new int[]{1,2},getLeastNumbers(new int[]{3,2,1},2));
        Assert.assertArrayEquals(new int[]{0},getLeastNumbers(new int[]{0,1,2,1},1));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans=new int[k];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int v:arr){
            for(int i=0;i<ans.length;i++){
                if(v<ans[i]){
                    for(int j=ans.length-2;j>=i;j--){
                        ans[j+1]=ans[j];
                    }
                    ans[i]=v;
                    break;
                }
            }
        }
        return ans;
    }
}
