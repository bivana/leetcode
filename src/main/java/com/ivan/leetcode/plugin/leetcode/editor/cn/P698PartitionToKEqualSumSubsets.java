package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 698. 划分为k个相等的子集
// 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 705 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class P698PartitionToKEqualSumSubsets{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(true,solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4));
        Assert.assertEquals(false,solution.canPartitionKSubsets(new int[]{1,2,3,4},3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int per;
        boolean[] dp;
        public boolean canPartitionKSubsets(int[] nums, int k) {
            this.nums=nums;
            int all=0;
            int max=Integer.MIN_VALUE;
            for(int i:nums){
                all+=i;
                max=Math.max(max,i);
            }
            if(all%k!=0){//不能等分
                return false;
            }
            per=all/k;
            if(max>per){//最大的超过了，直接返回
                return false;
            }
            dp=new boolean[1<<(nums.length)];
            Arrays.fill(dp,true);
            return dfs((1<<nums.length)-1,0);
        }

        // s表示当前状态，二进制1表示数字可用
        // p表示当前part的和
        public boolean dfs(int s,int p){
            if(s==0){
                return true;
            }
            if(!dp[s]){
                return dp[s];
            }
            dp[s]=false;
            for(int i=0;i<nums.length;i++){
                if(((s>>i)&1)!=1){//数字已选，不可用
                    continue;
                }
                if(p+nums[i]>per){//超出了部分选择
                    continue;
                }
                if(dfs(s^(1<<i),(p+nums[i])%per)){
                    return true;
                }
            }
            return false;
        }

//        int[] nums;
//        int per, n;
//        boolean[] dp;
//
//        public boolean canPartitionKSubsets(int[] nums, int k) {
//            this.nums = nums;
//            int all = Arrays.stream(nums).sum();
//            if (all % k != 0) {//不可整除，直接反馈false
//                return false;
//            }
//            per = all / k;//每个的和
//            Arrays.sort(nums);
//            n = nums.length;
//            if (nums[n - 1] > per) {//最大的大于，直接返回false
//                return false;
//            }
//            dp = new boolean[1 << n];//记忆dp
//            Arrays.fill(dp, true);//默认全为true
//            return dfs((1 << n) - 1, 0);
//        }
//
//        //自顶向下
//        //s 当前状态,s的二进制为1，表示该数字可选
//        //p 当前批次的和
//        public boolean dfs(int s ,int p){
//            if (s == 0) {//选完了，直接返回
//                return true;
//            }
//            if (!dp[s]) {//如果dp下不能组成，直接反馈false
//                return dp[s];
//            }
//            dp[s] = false;
//            for (int i = 0; i < n; i++) {
//                if (nums[i] + p > per) {//超出了，不能匹配
//                    break;
//                }
//                if (((s >> i) & 1) != 0) {//该灯可用
//                    if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}

