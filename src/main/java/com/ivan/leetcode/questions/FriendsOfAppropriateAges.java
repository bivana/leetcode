package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 825. 适龄的朋友
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 *
 * 提示：
 *
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 * */
public class FriendsOfAppropriateAges {

    @Test
    public void test(){
//        Assert.assertEquals(2,numFriendRequests(new int[]{16,16}));
        Assert.assertEquals(2,numFriendRequests(new int[]{16,17,18}));
        Assert.assertEquals(3,numFriendRequests(new int[]{20,30,100,110,120}));
    }

     // age[y] > 0.5 * age[x] + 7
    //age[y] <= age[x]
    //age[y] <= 100 || age[x] >= 100
    public int numFriendRequests(int[] ages) {
        int ans=0;
        TreeMap<Integer,Integer> map=new TreeMap<>((a,b)->b.compareTo(a));
        for(int age:ages){
            map.put(age,map.getOrDefault(age,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        for(int i=0;i<list.size();i++){
            Map.Entry<Integer,Integer> x=list.get(i);
            if(x.getValue()>1 && x.getKey()>14){//通过结论推导出来的，当x和y值相同时且age>14，那么可以互相发送清酒
                ans+=(x.getValue()-1)*(x.getValue());//如果存在相同值，可以互发，每个人可以发v-1次请求，有v人发
            }
            if(i<list.size()-1){
                for(int j=i+1;j<list.size();j++){
                    Map.Entry<Integer,Integer> y=list.get(j);
                    if(x.getKey()>=100||y.getKey()<=100){
                        if(y.getKey()<=x.getKey()){
                            if(y.getKey()>x.getKey()*0.5+7){
                                ans+=x.getValue()*y.getValue();
                            }
                        }
                    }
                }
            }

        }
        return ans;
    }
}
