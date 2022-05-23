package com.ivan.leetcode.plugin.leetcode.editor.cn;
//462 最少移动次数使数组元素相等 II
//给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。 
//
// 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：2
//解释：
//只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,2,9]
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 数学 排序 👍 196 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P462MinimumMovesToEqualArrayElementsIi{

    private Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(2,solution.minMoves2(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        //f(i)=suml+sumr+(nums[i]-nums[i-1])*(i-1)-(nums[i]-nus[i-1])*(nums.length-(i))
        long suml=0;//左边变化需要的步数
        long sumr=0;//右边变化需要的步数
        for(int i=1;i<nums.length;i++){
            sumr+=(nums[i]-nums[0]);
        }
        long min=suml+sumr;
        for(int i=1;i<nums.length;i++){
            int interval=nums[i]-nums[i-1];
            suml=suml+interval*(i);
            sumr=sumr+ -interval*(nums.length-i);
            min=Math.min(min,suml+sumr);
        }
        return (int)min;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}