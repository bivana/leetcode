package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 319. 灯泡开关
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 *
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 *
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= n <= 109
 * */
public class BulbSwitcher {

    @Test
    public void test(){
        Assert.assertEquals(1,bulbSwitch(3));
        Assert.assertEquals(0,bulbSwitch(0));
        Assert.assertEquals(1,bulbSwitch(1));
    }

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    //暴力法，超时
//    public int bulbSwitch(int n) {
//        if(n==0){
//            return 0;
//        }
//        int[] array=new int[n];
//        for(int i=1;i<=n;i++){ //第i轮
//            for(int j=1;j<=n;j++){//第i轮每几位需要切换
//                if(j%i==0){
//                    swap(array,j-1);
//                }
//            }
//            System.out.println(array.toString());
//        }
//        int ans=0;
//        for(int i:array){
//            ans=ans+i;
//        }
//        return ans;
//    }

    public void swap(int[] array,int index){
        if(array[index]==0){
            array[index]=1;
        }else{
            array[index]=0;
        }
    }
}
