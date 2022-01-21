package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 * */
public class HandOfStraights {

    @Test
    public void test(){
//        Assert.assertEquals(false,isNStraightHand(new int[]{233722108,386144634,221638886,175028874,408337082,91410299,793763682,972910825,627251147,135020779},2));
        Assert.assertEquals(true,isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
        Assert.assertEquals(false,isNStraightHand(new int[]{1,2,3,4,5},4));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        for(int i:hand){
            treeMap.put(i,treeMap.getOrDefault(i,0)+1);
        }
        while (!treeMap.isEmpty()){
            int start=treeMap.firstKey();
            for(int i=start;i<start+groupSize;i++){
                if(treeMap.getOrDefault(i,0)==0){
                    return false;
                }
                treeMap.put(i,treeMap.get(i)-1);
                if(treeMap.get(i)==0){
                    treeMap.remove(i);
                }
            }
        }
        return true;
    }

//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        int[] memo=new int[110];
//        for(int i:hand){
//            memo[i]++;
//        }
//        int i=0;
//        while (i<memo.length){
//            if(memo[i]>0){
//                if(i>memo.length-groupSize){
//                    return false;
//                }
//                for(int j=i;j<i+groupSize;j++){
//                    if(memo[j]==0){
//                        return false;
//                    }
//                    memo[j]--;
//                }
//            }else{
//                i++;
//            }
//
//        }
//        return true;
//    }
}
