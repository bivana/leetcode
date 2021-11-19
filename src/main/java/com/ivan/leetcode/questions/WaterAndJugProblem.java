package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 通过次数22,627提交次数64,431
 * 在真实的面试中遇到过这道题？
 * */
public class WaterAndJugProblem extends TestAbstract{

    @Test
    public void test(){
        Assert.assertEquals(false,canMeasureWater(1,1,12));
        Assert.assertEquals(true,canMeasureWater(34,5,6));
        Assert.assertEquals(false,canMeasureWater(0,0,1));
        Assert.assertEquals(true,canMeasureWater(0,0,0));
        Assert.assertEquals(true,canMeasureWater(3,5,4));
        Assert.assertEquals(false,canMeasureWater(2,6,5));
    }

    public static void main(String[] args){
        System.out.println(34%4);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z){
            return false;
        }
        if(z==0){
            return true;
        }
        if(x==0||y==0){
            return z==x+y;
        }
        return z%gct(x,y)==0;
    }

    public int gct(int a,int b){
        int n=0;
        while(b!=0){
            n=a%b;
            a=b;
            b=n;
        }
        return a;
    }

    public boolean canMeasureWater2(int x, int y, int z) {
        if(z==0){
            return true;
        }
        if(x+y<z){
            return false;
        }
        List<Integer> jug=new ArrayList<>();
        if(x!=0){
            jug.add(x);
        }
        if(y!=0){
            jug.add(y);
        }
        while(x!=0 && y!=0){
            if(x<y){
                int temp=x;
                x=y;
                y=temp;
            }
            int sub=x%y;
            if(sub!=0){
                jug.add(sub);
            }
            x=y;
            y=sub;
        }


        int[] target=new int[z+1];
        for(int i=1;i<=z;i++){
            for(int j=0;j<jug.size();j++){
                int sub=i-jug.get(j);
                if(sub>=0 && sub==target[sub]){
                    target[i]=i;
                }
            }
        }
        return target[z]!=0;
    }
}
