package com.ivan.leetcode.plugin.leetcode.editor.cn;
//870. 优势洗牌
// 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
//目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 234 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class P870AdvantageShuffle{
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            TreeMap<Integer,Integer> treeMap=new TreeMap<>();
            for(int num:nums1){
                treeMap.put(num,treeMap.getOrDefault(num,0)+1);
            }
            int[] ans=new int[nums1.length];
            for(int i=0;i<nums2.length;i++){
                Integer cur=treeMap.ceilingKey(nums2[i]+1);
                if(cur==null){
                    cur=treeMap.ceilingKey(-1);
                }
                ans[i]=cur;
                treeMap.put(cur,treeMap.get(cur)-1);
                if(treeMap.get(cur)==0){
                    treeMap.remove(cur);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

