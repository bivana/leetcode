package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * */
public class MaximumProductOfWordLengths {

    @Test
    public void test(){
        Assert.assertEquals(16,maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        Assert.assertEquals(4,maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        Assert.assertEquals(0,maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }

    public int maxProduct(String[] words) {
        int[] wordsInt=new int[words.length];
        //将字符转换为二进制
        for(int i=0;i<words.length;i++){
            int ana=0;
            for(char c:words[i].toCharArray()){
                int l=1<<(c-'a');
                if((ana&l)==0){//表示没有相同的，那么加上
                    ana=ana+l;
                }
            }
            wordsInt[i]=ana;
        }
        int max=0;
        for(int i=0;i<wordsInt.length-1;i++){
            double target=(double)(max/words[i].length());
            for(int j=i+1;j<wordsInt.length;j++){
                if(words[j].length()>target && (wordsInt[i]&wordsInt[j])==0){
                    max=words[i].length()*words[j].length();
                    target=words[j].length();
                }
            }
        }
        return max;
    }
}
