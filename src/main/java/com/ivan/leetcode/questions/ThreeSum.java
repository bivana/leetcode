package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

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

    @Test
    public void test(){
        List<List<Integer>> rs=threeSum(new int[]{-2,0,0,2,2});
        ShowUtil.showListMatrix(rs);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int start=i+1;
            int end=nums.length-1;
            if(nums[i]>0){
                break;
            }else if(i>0 && nums[i]==nums[i-1]){
                continue;
            }else{
                while (start<end){
                    int temp=nums[i]+nums[start]+nums[end];
                    if(temp==0){
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[start],nums[end]}));
                        start++;
                        while (start<end && nums[start]==nums[start-1]){
                            start++;
                        }
                        end--;
                        while (start<end && nums[end]==nums[end+1]){
                            end--;
                        }
                    }else if (temp<0){
                        start++;
                        while (start<end && nums[start]==nums[start-1]){
                            start++;
                        }
                    }else{
                        end--;
                        while (start<end && nums[end]==nums[end+1]){
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length-2;i++){
//            int l=i+1;
//            int r=nums.length-1;
//            if(nums[i]>0){
//                return result;
//            }else if(i>0 && nums[i]==nums[i-1]){
//                continue;
//            }else {
//                while (l<r){
//                    int temp=nums[i]+nums[l]+nums[r];
//                    if(temp==0){
//                        result.add(Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]}));
//                        while(l < r && nums[l] == nums[++l]);
//                        while(l < r && nums[r] == nums[--r]);
//                    }else if(temp>0){
//                        while(l < r && nums[r] == nums[--r]);
//                    }else{
//                        while(l < r && nums[l] == nums[++l]);
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
