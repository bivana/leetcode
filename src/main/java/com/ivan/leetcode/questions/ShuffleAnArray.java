package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 * 通过次数61,651提交次数104,643
 * */
public class ShuffleAnArray {

    @Test
    public void test(){
        Solution solution=new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        Assert.assertArrayEquals(new int[]{1,2,3},solution.reset());
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    public static void main(String[] args){
        int[] array=new int[11];
        for(int i=0;i<10000;i++){
            int j=(int)(Math.random()*10);
            array[j]++;
        }
        System.out.println(Arrays.toString(array));


    }

    class Solution {

        int[] array;

        public Solution(int[] nums) {
            array=nums;
        }

        public int[] reset() {
            return array;
        }

        public int[] shuffle() {
            List<Integer> list= new ArrayList<>();
            for(int i:array){
                list.add(i);
            }
            int[] sh=new int[array.length];
            for(int i=sh.length-1;i>=0;i--){
                int index=(int)(Math.random()*(i+1));
                sh[i]=list.get(index);
                list.remove(index);
            }
            return sh;
        }
    }
}
