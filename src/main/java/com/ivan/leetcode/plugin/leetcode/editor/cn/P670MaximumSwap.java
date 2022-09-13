package com.ivan.leetcode.plugin.leetcode.editor.cn;

//670. 最大交换
// 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 304 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P670MaximumSwap{

    public Solution solution=new Solution();

    @Test
    public void test(){
//        Assert.assertEquals(98863,solution.maximumSwap(98368));
        Assert.assertEquals(7236,solution.maximumSwap(2736));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] array=String.valueOf(num).toCharArray();
            int maxIdx=array.length-1;
            int idx1=-1;
            int idx2=-1;
            for(int i=array.length-2;i>=0;i--){
                if(array[i]>array[maxIdx]){
                    maxIdx=i;
                }else if(array[i]<array[maxIdx]){
                    idx1=i;
                    idx2=maxIdx;
                }
            }
            if(idx1!=-1){
                char temp=array[idx1];
                array[idx1]=array[idx2];
                array[idx2]=temp;
            }
            return Integer.valueOf(String.valueOf(array));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
