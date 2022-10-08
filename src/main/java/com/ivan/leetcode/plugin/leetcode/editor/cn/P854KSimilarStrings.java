package com.ivan.leetcode.plugin.leetcode.editor.cn;

//854. 相似度为 K 的字符串
// 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 167 👎 0


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P854KSimilarStrings{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(1,solution.kSimilarity("ab","ba"));
        Assert.assertEquals(2,solution.kSimilarity("abc","bca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kSimilarity(String s1, String s2) {
            char[] org=s1.toCharArray();
            char[] target=s2.toCharArray();
            int k=0;
            Map<Character, Map<Character,Integer>> map=new HashMap<>();
            for(int i=0;i<org.length;i++){
                if(map.get(org[i])==null){

                }
            }
            for(int i=0;i<target.length;i++){
                if(target[i]!=org[i]){

                }
            }
            return k;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
