package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SingleElementInASortedArray {

    @Test
    public void test(){
        Assert.assertEquals(2,singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        Assert.assertEquals(10,singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));

    }

    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int r=nums.length;
        //左闭右开
        while (l<r){
            int mid=(l+r)>>1;
            if(mid==0||mid==nums.length-1){
                return nums[mid];
            }
            //左条件满足，在左边
            if((mid%2==1&&nums[mid]!=nums[mid-1])||(mid%2==0)&&nums[mid]!=nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }

//    public int singleNonDuplicate(int[] nums) {
//        int ans=0;
//        for(int i:nums){
//            ans=ans^i;
//        }
//        return ans;
//    }
}
