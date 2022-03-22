package com.ivan.leetcode.plugin.leetcode.editor.cn;
//338 比特位计数
//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。 
//
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
// 
// 
// Related Topics 位运算 动态规划 👍 936 👎 0

import org.junit.Test;

public class P338CountingBits{

    @Test
    public void test(){
        System.out.println(0>>1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            ans[i]=1+ans[i-highestOneBit(i)];
        }
        return ans;
    }

        public  int highestOneBit(int i) {
            // HD, Figure 3-1
            i |= (i >>  1);
            i |= (i >>  2);
            i |= (i >>  4);
            i |= (i >>  8);
            i |= (i >> 16);
            return i - (i >>> 1);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}