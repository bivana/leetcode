package com.ivan.leetcode.plugin.leetcode.editor.cn;
//357 统计各位数字都不同的数字个数
//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 👍 217 👎 0

import java.io.InputStream;

public class P357CountNumbersWithUniqueDigits{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>10){
            return 0;
        }
        int ans=0;
        int totalC=getJiec(10);
        int totalN=getJiec(n);
        ans=totalC/totalN;
        return ans;
    }

    public int getJiec(int n){
        int total=1;
        for(int i=1;i<=n;i++){
            total*=i;
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}