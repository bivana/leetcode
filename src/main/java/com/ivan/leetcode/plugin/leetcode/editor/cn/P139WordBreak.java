package com.ivan.leetcode.plugin.leetcode.editor.cn;
//139 单词拆分
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1594 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P139WordBreak{

    private Solution solution=new Solution();
    @Test
    public void test(){
        Assert.assertEquals(true,solution.wordBreak("leetcode",Arrays.asList(new String[]{"leet","code","abcdef"})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()+1];
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2.length()).compareTo(o1.length());
            }
        });
        dfs(s,0,wordDict);
        return dp[0];
    }

    public boolean dfs(String s,int start,List<String> wordDict){
        if(dp[start]!=null){
            return dp[start];
        }
        if(start==s.length()){
            dp[start]=true;
            return true;
        }
        for(String word:wordDict){
            if(s.startsWith(word,start)){
                boolean can=dfs(s,start+word.length(),wordDict);
                if(can){
                    dp[start]=true;
                    return true;
                }
            }
        }
        dp[start]=false;
        return dp[start];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}