package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.CreateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * */
public class MinimumTimeDifference {

    @Test
    public void test(){
        Assert.assertEquals(120,findMinDifference(Arrays.asList(new String[]{"00:00","04:00","22:00"})));

        Assert.assertEquals(1,findMinDifference(Arrays.asList(new String[]{"23:59","00:00"})));
        Assert.assertEquals(0,findMinDifference(Arrays.asList(new String[]{"00:00","23:59","00:00"})));
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list=new ArrayList<>(timePoints.size());
        for(String s:timePoints){
            Integer minute=Integer.valueOf(s.substring(3));
            minute+=Integer.valueOf(s.substring(0,2))*60;
            list.add(minute);
        }
        Collections.sort(list);
        int ans=getInterval(list.get(0),list.get(list.size()-1));
        for(int i=1;i<list.size();i++){
            ans=Math.min(ans,getInterval(list.get(i),list.get(i-1)));
        }
        return ans;
    }

    int dayMinutes=1440;

    public int getInterval(int a,int b){
        if(a>=b){
            return Math.min(a-b,b+dayMinutes-a);
        }else{
            return Math.min(b-a,a+dayMinutes-b);
        }
    }


}
