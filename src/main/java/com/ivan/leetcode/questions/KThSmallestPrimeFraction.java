package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 786. 第 K 个最小的素数分数
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 示例 2：
 *
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * 通过次数8,372提交次数14,274
 * */
public class KThSmallestPrimeFraction {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{11,37},kthSmallestPrimeFraction(new int[]{1,2,11,37,83,89},11));
//        1/89 1/83 2/89 2/83 1/37 2/37 1/11 11/89 11/83 2/11 11/37 37/89 37/83 1/2 83/89
        Assert.assertArrayEquals(new int[]{2,5},kthSmallestPrimeFraction(new int[]{1,2,3,5},3));
        Assert.assertArrayEquals(new int[]{1,7},kthSmallestPrimeFraction(new int[]{1,7},1));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        return null;
    }

//    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//        Stack<Double[]> stack=new Stack<>();
//        Stack<Double[]> tmp=new Stack<>();
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=arr.length-1;j>i;j--){
//                Double[] v=new Double[]{(double)arr[i]/arr[j],(double)arr[i],(double)arr[j]};
//                if(stack.size()==k){//达到长度，进行判断
//                    if(v[0]<stack.peek()[0]){
//                        stack.pop();//直接弹出最后一个
//                        //看下是否需要继续
//                        while (!stack.isEmpty()&&stack.peek()[0]>v[0]){
//                            tmp.push(stack.pop());
//                        }
//                        stack.push(v);
//                        while (!tmp.isEmpty()){
//                            stack.push(tmp.pop());
//                        }
//                    }
//                }else{//直接放入
//                    //看下是否需要继续
//                    while (!stack.isEmpty()&&stack.peek()[0]>v[0]){
//                        tmp.push(stack.pop());
//                    }
//                    stack.push(v);
//                    while (!tmp.isEmpty()){
//                        stack.push(tmp.pop());
//                    }
//                }
//            }
//        }
//        int[] ans=new int[2];
//        Double[] t=stack.peek();
//        ans[0]=t[1].intValue();
//        ans[1]=t[2].intValue();
//        return ans;
//
//    }
}
