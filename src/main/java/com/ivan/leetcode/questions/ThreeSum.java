package com.ivan.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * */
public class ThreeSum {

    public static void main(String[] args){
        ThreeSum threeSum=new ThreeSum();
        List<List<Integer>> list=threeSum.threeSum(new int[]{-2,0,0,2,2});
        for(List<Integer> l:list){
            for(Integer a:l){
                System.out.print(a);
            }
            System.out.println();
        }
    }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            if(nums[i]>0){
                return result;
            }else if(i>0 && nums[i]==nums[i-1]){
                continue;
            }else {
                while (l<r){
                    int temp=nums[i]+nums[l]+nums[r];
                    if(temp==0){
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]}));
                        while(l < r && nums[l] == nums[++l]);
                        while(l < r && nums[r] == nums[--r]);
                    }else if(temp>0){
                        while(l < r && nums[r] == nums[--r]);
                    }else{
                        while(l < r && nums[l] == nums[++l]);
                    }
                }
            }
        }
        return result;
    }
}
