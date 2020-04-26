package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 * 通过次数33,759提交次数69,600
 * */
public class ShortEncodingOfWords {

    @Test
    public void test(){
        Assert.assertEquals(10,minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public int minimumLengthEncoding(String[] words) {
        if(words==null){
            return 0;
        }
        Arrays.sort(words,(a,b)->b.length()-a.length());
        int len=0;
        Trie trie=new Trie();
        for(String str:words){
            len+=trie.insert(str);
        }
        return len;
    }

    class Trie{
        private TrieNode root;
        public Trie(){
            root=new TrieNode();
        }

        public int insert(String str){
            TrieNode cur=root;
            if(str==null||"".equals(str)){
                return 0;
            }
            boolean isNew=false;
            for(int i=str.length()-1;i>=0;i--){
                int c = str.charAt(i) - 'a';
                if(cur.children[c]==null){
                    isNew=true;
                    cur.children[c]=new TrieNode();
                }
                cur=cur.children[c];
            }
            return isNew?str.length()+1:0;
        }
    }

    /**
     * 字典树节点
     * */
    class TrieNode{
        private char val;
        private TrieNode[] children=new TrieNode[26];

        public TrieNode(){}
    }
}
