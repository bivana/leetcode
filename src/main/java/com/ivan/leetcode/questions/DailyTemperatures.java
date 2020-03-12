package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 通过次数33,657提交次数56,969
 * 在真实的面试中遇到过这道题？
 *
 * */
public class DailyTemperatures {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }



    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] rs=new int[T.length];
        for(int i=0;i<T.length;i++){
            while (!stack.empty()){
                int index=stack.peek();
                if(T[i]>T[index]){
                    rs[index]=i-index;
                    stack.pop();
                    continue;
                }
                break;
            }
            stack.push(i);
        }
        return rs;
    }


    /**
     *
     * */
    public int[] dailyTemperatures2(int[] T) {
        int[] rs=new int[T.length];
        for(int i=T.length-2;i>=0;i--){
            int j=i+1;
            while (j<T.length){
                if(T[j]>T[i]){
                    rs[i]=j-i;
                    break;
                }
                if(rs[j]==0){
                    break;
                }
                j+=rs[j];
            }

        }
        return rs;
    }
}
