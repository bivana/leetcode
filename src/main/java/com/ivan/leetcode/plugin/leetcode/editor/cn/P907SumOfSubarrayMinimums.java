package com.ivan.leetcode.plugin.leetcode.editor.cn;
//
// 907. 子数组的最小值之和
// 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 511 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P907SumOfSubarrayMinimums{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(17,solution.sumSubarrayMins(new int[]{3,1,2,4}));
        Assert.assertEquals(444,solution.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            if(arr.length==0){
                return 0;
            }
            long ans=0;
            Map<Integer,Long> map=new HashMap<>();
            for(int i=0;i<arr.length;i++){
                int val=arr[i];
                int cnt=1;
                for(Map.Entry<Integer,Long> entry:map.entrySet()){
                    if(entry.getKey()<=val){
                        entry.setValue(entry.getValue()*2);
                    }else{
                        cnt++;
                    }
                }
                map.put(val,map.getOrDefault(val,0l)+cnt);
            }
            for(Map.Entry<Integer,Long> entry:map.entrySet()){
                ans+=entry.getKey()*entry.getValue();
            }
            return (int)Math.floorMod(ans,(long)Math.pow(10,9))+7;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
