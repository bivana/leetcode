package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * */
public class XOfAKindInADeckOfCards {

    @Test
    public void test(){
        Assert.assertEquals(true,hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        Assert.assertEquals(false,hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
        Assert.assertEquals(false,hasGroupsSizeX(new int[]{1}));
        Assert.assertEquals(true,hasGroupsSizeX(new int[]{1,1}));
        Assert.assertEquals(true,hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:deck){
            if(map.get(i)==null){
                map.put(i,0);
            }
            map.put(i,map.get(i)+1);
        }
        int gcd=-1;
        for(int v:map.values()){
            if(gcd==-1){
                gcd=v;
            }else{
                gcd=gcd(gcd,v);
            }
        }
        return gcd>=2;

    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
