package com.ivan.leetcode.plugin.leetcode.editor.cn;//
// 792. 匹配子序列的单词数
// 给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 321 👎 0


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P792NumberOfMatchingSubsequences{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(3,solution.numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));
        Assert.assertEquals(2,solution.numMatchingSubseq("dsahjpjauf",new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
   }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos=new ArrayList[25];
        for(int i=0;i<pos.length;i++){
            pos[i]=new ArrayList<>();
        }
        for(int i=0;i<s.length();i++){
            pos[s.charAt(i)-'a'].add(i);
        }
        int ans=0;
        wordloop: for(String word:words){
            int i=0;
            for(char c:word.toCharArray()){
                int j=binarySearchGreater(pos[c-'a'],i);
                if(i==-1){
                    continue wordloop;
                }
            }
            ans++;
        }
        return ans;
    }

    /**
     * 二分查找比i大于或等于的下标
     * */
    public int binarySearchGreater(List<Integer> list,int i){
        int l=0;
        int r=list.size()-1;
        while (l<r){
            int mid=(l+r)>>1;
            if(list.get(mid)<=i){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return list.get(l);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
