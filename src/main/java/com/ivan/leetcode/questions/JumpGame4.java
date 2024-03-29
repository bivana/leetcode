package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * */
public class JumpGame4 {

    @Test
    public void test(){
        Assert.assertEquals(2,minJumps(new int[]{6,1,9}));
        Assert.assertEquals(3,minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        Assert.assertEquals(0,minJumps(new int[]{7}));
        Assert.assertEquals(1,minJumps(new int[]{7,6,9,6,9,6,9,7}));
        Assert.assertEquals(3,minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13}));
    }

    //map 值,索引
    //dp[i] 表示到达尾部的最小步数
    //倒序
    public int minJumps(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        int[] dp=new int[arr.length];
        dp[dp.length-1]=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length-1;i++){
            List<Integer> list=map.get(arr[i]);
            if(list==null){
                list=new ArrayList<>();
                map.put(arr[i],list);
            }
            list.add(i);
        }
        //使用bfs
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(dp.length-1);
        while (!queue.isEmpty()){
            int i=queue.poll();
            //处理两边
            int next=i+1;
            if(next<arr.length){
                if(dp[next]==0){
                    dp[next]=dp[i]+1;
                    queue.add(next);
                }
            }
            int pre=i-1;
            if(pre>=0){
                if(dp[pre]==0){
                    dp[pre]=dp[i]+1;
                    queue.add(i-1);
                }
            }
            if(next==0||pre==0){
                return dp[0];
            }


            List<Integer> canGoList=map.get(arr[i]);
            if(canGoList==null){
                continue;
            }
            Iterator<Integer> iterator=canGoList.iterator();
            while (iterator.hasNext()){
                int j=iterator.next();
                //没有匹配过的
                if(dp[j]==0){
                    dp[j]=dp[i]+1;
                }
                iterator.remove();
                queue.add(j);
                if(j==0){
                    return dp[j];
                }
            }


        }
        return dp[0];
    }
}
