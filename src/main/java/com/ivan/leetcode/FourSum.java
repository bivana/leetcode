package com.ivan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * */
public class FourSum {

    public static void main(String[] args){
        FourSum fourSum=new FourSum();
//        List<List<Integer>> lists=fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
        List<List<Integer>> lists=fourSum.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11);
        for(List<Integer> l:lists){
            for(Integer i:l){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int l1=0;
        int r1=nums.length-1;
        for(l1=0;l1<nums.length-3;l1++){
            if(l1>0&&nums[l1]==nums[l1-1]){
                continue;
            }
            for(r1=nums.length-1;l1<r1;r1--){
                if(r1<nums.length-1 && nums[r1]==nums[r1+1]){
                    continue;
                }
                int l2=l1+1;
                int r2=r1-1;
                while (l2<r2){
                    int temp=nums[l1]+nums[r1]+nums[l2]+nums[r2];
                    if(temp==target){
                        result.add(Arrays.asList(new Integer[]{nums[l1],nums[l2],nums[r2],nums[r1]}));
                        while(l2 < r2 && nums[l2] == nums[++l2]);
                        while(l2 < r2 && nums[r2] == nums[--r2]);
                    }else if(temp<target){
                        while(l2 < r2 && nums[l2] == nums[++l2]);
                    }else{
                        while(l2 < r2 && nums[r2] == nums[--r2]);
                    }
                }
            }
        }
        return result;
    }
}
