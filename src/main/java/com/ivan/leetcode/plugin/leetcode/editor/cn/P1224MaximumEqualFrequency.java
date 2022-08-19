package com.ivan.leetcode.plugin.leetcode.editor.cn;//

// 1224. 最大相等频率
// 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 89 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P1224MaximumEqualFrequency{
    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(8,solution.maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
        Assert.assertEquals(7,solution.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
        Assert.assertEquals(13,solution.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<Integer, Integer>();//出现次数为x的个数
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();//num[i]出现的次数
            int res = 0, maxFreq = 0;
            for (int i = 0; i < nums.length; i++) {
                //先删除旧de
                if (count.getOrDefault(nums[i], 0) > 0) {
                    freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
                }
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
                maxFreq = Math.max(maxFreq, count.get(nums[i]));
                //更新统计次数
                freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
                ////最大出现次数 \textit{maxFreq} = 1maxFreq=1：那么所有数的出现次数都是一次，随意删除一个数既可符合要求。
//                所有数的出现次数都是 \textit{maxFreq}maxFreq 或 \textit{maxFreq} - 1maxFreq−1，并且最大出现次数的数只有一个：删除一个最大出现次数的数，那么所有数的出现次数都是 \textit{maxFreq} - 1maxFreq−1。
//
//                除开一个数，其他所有数的出现次数都是 \textit{maxFreq}maxFreq，并且该数的出现次数为 11：直接删除出现次数为 11 的数，那么所有数的出现次数都是 \textit{maxFreq}maxFreq。

                boolean ok = maxFreq == 1 ||
                        freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                        freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
                if (ok) {
                    res = Math.max(res, i + 1);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

