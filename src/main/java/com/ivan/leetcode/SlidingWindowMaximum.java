package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 * */
public class SlidingWindowMaximum {

    public static void main(String[] args){
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        deq.add(3);
        deq.add(5);
        deq.add(1);
        System.out.println(deq.getFirst());
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7},maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));

    }

    /**
     * 最大值记录法
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int[] rs=new int[nums.length-k+1];
        Integer max=findMax(nums,0,k);
        rs[0]=max;
        for(int i=1;i<nums.length-k+1;i++){
            if(nums[i-1]==max || nums[i+k-1]>max){
                max=findMax(nums,i,i+k);
            }
            rs[i]=max;
        }
        return rs;
    }

    public int findMax(int[] nums,int startIndex,int endIndex){
        int max=Integer.MIN_VALUE;
        for(int i=startIndex;i<endIndex;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }






    /**
     * tree map
     * */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int[] rs=new int[nums.length-k+1];
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        for(int i=0;i<k;i++){
            if(treeMap.get(nums[i])==null){
                treeMap.put(nums[i],1);
            }else{
                treeMap.put(nums[i],treeMap.get(nums[i])+1);
            }

        }
        rs[0]=treeMap.lastKey();
        for(int i=1;i<nums.length-k+1;i++){
            if(treeMap.get(nums[i-1])<=1){
                treeMap.remove(nums[i-1]);
            }else{
                treeMap.put(nums[i-1],treeMap.get(nums[i-1])-1);
            }
            if(treeMap.get(nums[i+k-1])==null){
                treeMap.put(nums[i+k-1],1);
            }else{
                treeMap.put(nums[i+k-1],treeMap.get(nums[i+k-1])+1);
            }
            rs[i]=treeMap.lastKey();
        }
        return rs;
    }

    /**
     * 暴力破解法
     * */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int[] rs=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(nums[j]>max){
                    max=nums[j];
                }
            }
            rs[i]=max;
        }
        return rs;
    }
}
