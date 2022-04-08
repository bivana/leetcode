package com.ivan.leetcode.plugin.leetcode.editor.cn;
//954 二倍数对数组
//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 97 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P954ArrayOfDoubledPairs{

    private Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertFalse(solution.canReorderDoubled(new int[]{-5,-2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(arr);
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:arr){
            if(map.getOrDefault(i,0)==0){
                continue;
            }
            map.put(i,map.getOrDefault(i,0)-1);
            int target=0;
            if(i<0){
                if(i%2!=0){
                    return false;
                }
                target= i/2;
            }else{
                target=i*2;
            }
            if(map.getOrDefault(target,0)==0){
                return false;
            }else{
                map.put(target,map.get(target)-1);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}