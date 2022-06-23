package com.ivan.leetcode.plugin.leetcode.editor.cn;
//30 串联所有单词的子串
//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 706 👎 0

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P30SubstringWithConcatenationOfAllWords{

    @Test
    public void test(){
        Assert.assertArrayEquals(new Integer[]{0,9},solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}).toArray(new Integer[2]));
    }

    public Solution solution=new Solution();

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        //构建hashmap
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int m=words[0].length();
        int targetLen=words.length*m;
        top:for(int i=0;i+targetLen-1<s.length();i++){
            Map<String,Integer> curMap=new HashMap<>();
            for(int j=i;j<i+targetLen;j=j+m){
                String sub=s.substring(j,j+m);
                if(!map.containsKey(sub)){
                    continue top;
                }
                curMap.put(sub,curMap.getOrDefault(sub,0)+1);
            }
            if(curMap.equals(map)){
                ans.add(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}