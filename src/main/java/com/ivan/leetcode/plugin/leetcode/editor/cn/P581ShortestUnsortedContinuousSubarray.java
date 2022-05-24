package com.ivan.leetcode.plugin.leetcode.editor.cn;
//581 最短无序连续子数组
//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 857 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P581ShortestUnsortedContinuousSubarray{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(5,solution.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int minIndex=nums.length-1;
        int min=nums[minIndex];
        for(int i=nums.length-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]!=min){
                minIndex=i;
            }
        }
        int maxIndex=0;
        int max=nums[maxIndex];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]!=max){
                maxIndex=i;
            }
        }
        int len=maxIndex-minIndex;
        return len>0?len+1:0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}