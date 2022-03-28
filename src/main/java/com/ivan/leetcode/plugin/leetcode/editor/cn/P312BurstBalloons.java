package com.ivan.leetcode.plugin.leetcode.editor.cn;
//312 戳气球
//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 943 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P312BurstBalloons{

    private Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(167,solution.maxCoins(new int[]{3,1,5,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] dp;
        int[] val;

        public int maxCoins(int[] nums) {
            val=new int[nums.length+2];
            System.arraycopy(nums,0,val,1,nums.length);
            val[0]=1;
            val[val.length-1]=1;

            dp=new int[val.length][val.length];
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }

            return maxCoins(0,nums.length+1);
        }

        public int maxCoins(int left,int right){
            if(left>=right-1){
                return 0;
            }
            if(dp[left][right]!=-1){
                return dp[left][right];
            }
            for(int i=left+1;i<right;i++){
                int v=val[i]*val[left]*val[right];
                v+=maxCoins(left,i)+maxCoins(i,right);
                dp[left][right]=Math.max(dp[left][right],v);
            }
            return dp[left][right];
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}