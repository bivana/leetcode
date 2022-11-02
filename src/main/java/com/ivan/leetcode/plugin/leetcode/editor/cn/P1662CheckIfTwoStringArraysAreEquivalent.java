package com.ivan.leetcode.plugin.leetcode.editor.cn;//1662. 检查两个字符串数组是否相等
// 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10³ 
// 1 <= word1[i].length, word2[i].length <= 10³ 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
// word1[i] 和 word2[i] 由小写字母组成 
// 
//
// Related Topics 数组 字符串 👍 49 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P1662CheckIfTwoStringArraysAreEquivalent{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(true,solution.arrayStringsAreEqual(new String[]{"ab", "c"},new String[]{"a", "bc"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int i=0;
            int j=0;
            int x=0;
            int y=0;
            while (i<word1.length&&j<word2.length){
                while (x<word1[i].length()&&y< word2[j].length()){
                    if(word1[i].charAt(x)!=word2[j].charAt(y)){
                        return false;
                    }
                    x++;
                    y++;
                }
                if(x== word1[i].length()){
                    i++;
                    x=0;
                }
                if(y==word2[j].length()){
                    j++;
                    y=0;
                }
            }
            if(i==word1.length&&j== word2.length){
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
