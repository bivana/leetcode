package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 1668. 最大重复子字符串
// 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
//
// Related Topics 字符串 字符串匹配 👍 58 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P1668MaximumRepeatingSubstring{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(5,solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba" , "aaaba"));
        Assert.assertEquals(2,solution.maxRepeating("ababc","ab"));
        Assert.assertEquals(1,solution.maxRepeating("ababc","ba"));
        Assert.assertEquals(0,solution.maxRepeating("ababc","ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //动态规划解法
        //f(x)=f(x)+f(x-m)
        public int maxRepeating(String sequence, String word) {
            int ans = 0;
            int m = sequence.length();
            int n = word.length();
            int[] dp = new int[m];//表示这个位置是否是word
            for (int i = 0; i < m - n+1; i++) {
                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    if (word.charAt(j) != sequence.charAt(i + j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = (i - n >= 0 ? dp[i - n] : 0) + 1;
                    ans = Math.max(ans, dp[i]);
                }

            }
            return ans;
        }
    }

//        public int maxRepeating(String sequence, String word) {
//            int index=0;
//            int ans=0;
//            while ((index=sequence.indexOf(word,index))>=0){
//                int tmp=0;
//                int subIndx=index;
//                while (sequence.startsWith(word,subIndx)){
//                    tmp++;
//                    subIndx+=word.length();
//                }
//                ans=Math.max(tmp,ans);
//                index++;
//            }
//            return ans;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
