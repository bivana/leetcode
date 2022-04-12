package com.ivan.leetcode.plugin.leetcode.editor.cn;
//309 最佳买卖股票时机含冷冻期
//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1164 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P309BestTimeToBuyAndSellStockWithCooldown{

    private Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(3,solution.maxProfit(new int[]{1,2,4}));

        Assert.assertEquals(0,solution.maxProfit(new int[]{2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //0 持有，1 未持有，未冻结状态 ，2 未持有，冻结状态
        int[] dp=new int[3];
        dp[0]=-prices[0];//持有状态
        int[] dpTmp=new int[3];
        for(int i=1;i<prices.length;i++){
            // 持有状态，继续持有&非冻结买入
            dpTmp[0]=Math.max(dp[0],dp[1]-prices[i]);
            //非冻结状态，冻结解冻或者继续非冻结
            dpTmp[1]=Math.max(dp[1],dp[2]);
            // 冻结状态，卖出冻结
            dpTmp[2]=dp[0]+prices[i];
            dp=dpTmp;
        }
        return Math.max(dp[0],Math.max(dp[1],dp[2]));


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}