package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * */
public class MajorityElement {

    @Test
    public void test(){
        Assert.assertEquals(3,majorityElement(new int[]{3,2,3}));
        Assert.assertEquals(2,majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

//    Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int count=0;
        int cadinate=0;
        for(int i:nums){
            if(count==0){
                cadinate=i;
            }
            count=count+(i==cadinate?1:-1);
        }
        return cadinate;
    }

//    public int majorityElement(int[] nums) {
//        int majorTarget=nums.length/2;
//        Map<Integer,Integer> count=new HashMap<Integer, Integer>(majorTarget);
//        for(int i:nums){
//            count.put(i,(count.get(i)==null?0:count.get(i))+1);
//            if(count.get(i)>majorTarget){
//                return i;
//            }
//        }
//        return -1;
//    }
}
