package com.ivan.leetcode.plugin.leetcode.editor.cn;
//172 阶乘后的零
//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁴ 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 👍 594 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class P172FactorialTrailingZeroes{

    @Test
    public void test(){
        long sum=1;
        for(int i=1;i<=100;i++){
            sum*=i;
            System.out.println(i+":"+(sum));

        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        while (n!=0){
            ans+=(n/5);
            n=n/5;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}