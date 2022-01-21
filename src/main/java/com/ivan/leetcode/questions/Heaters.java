package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 *
 *
 * 示例 1:
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 * */
public class Heaters {

    @Test
    public void test(){
        Assert.assertEquals(161834419,findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        Assert.assertEquals(1,findRadius(new int[]{1,2,3},new int[]{2}));
        Assert.assertEquals(1,findRadius(new int[]{1,2,3,4},new int[]{1,4}));
        Assert.assertEquals(3,findRadius(new int[]{1,5},new int[]{2}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        int i=0;
        int last=heaters.length-1;
        for(int house:houses){
            //找到第一个比house大的
            while (i<heaters.length&&house>heaters[i]){
                i++;
            }
            //表示house都比热点大
            if(i==heaters.length){
                ans=Math.max(ans,house-heaters[last]);
            }else if(i==0){//表示头节点，house都比热点小
                ans=Math.max(ans,heaters[0]-house);
            }else{
                ans=Math.max(ans,Math.min(heaters[i]-house,house-heaters[i-1]));
            }
        }
        return ans;
    }
}
