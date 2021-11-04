package com.ivan.leetcode.questions;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * */
public class DesignAddAndSearchWordsDataStructure {

    @Test
    public void test(){
//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        Assert.assertEquals(false,wordDictionary.search("pad"));
//        Assert.assertEquals(true,wordDictionary.search("bad"));
//        Assert.assertEquals(true,wordDictionary.search(".ad"));
//        Assert.assertEquals(true,wordDictionary.search("b.."));

//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("a");
//        wordDictionary.addWord("a");
//        Assert.assertEquals(true,wordDictionary.search("."));
//        Assert.assertEquals(true,wordDictionary.search("a"));
//        Assert.assertEquals(false,wordDictionary.search("aa"));
//        Assert.assertEquals(true,wordDictionary.search("a"));
//        Assert.assertEquals(false,wordDictionary.search(".a"));
//        Assert.assertEquals(false,wordDictionary.search("a."));

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
//        Assert.assertEquals(false,wordDictionary.search("a"));
//        Assert.assertEquals(false,wordDictionary.search(".at"));
        wordDictionary.addWord("bat");

        Assert.assertEquals(true,wordDictionary.search(".at"));
        Assert.assertEquals(true,wordDictionary.search("an."));
        Assert.assertEquals(false,wordDictionary.search("a.d."));
        Assert.assertEquals(false,wordDictionary.search("b."));
        Assert.assertEquals(true,wordDictionary.search("a.d"));
        Assert.assertEquals(false,wordDictionary.search("."));
    }

    class WordDictionary {

        char c;

        boolean isWord=false;

        Map<Character,WordDictionary> subT=new HashMap<>();

        public WordDictionary() {

        }

        public void addWord(String word) {
            if(word==null||word.length()==0){
                return;
            }
            char ch=word.charAt(0);
            WordDictionary wordDictionary=subT.get(ch);
            if(wordDictionary==null) {
                wordDictionary = new WordDictionary();
                wordDictionary.c = ch;
                subT.put(ch, wordDictionary);
            }
            if(word.length()>1){
                wordDictionary.addWord(word.substring(1));
            }else{
                wordDictionary.isWord=true;
            }
        }

        public boolean search(String word) {
            if(word==null||word.length()==0){
                return false;
            }
            if(subT.isEmpty()){
                return false;
            }
            char ch=word.charAt(0);
            if(!subT.containsKey(ch)&&ch!='.'){
                return false;
            }
            if(word.length()==1){
                if(ch=='.'){
                    for(WordDictionary wordDictionary:subT.values()){
                        if(wordDictionary.isWord){
                            return true;
                        }
                    }
                    return false;
                }else{
                    return subT.get(ch).isWord;
                }
            }
            if(ch=='.'){
                for(WordDictionary wordDictionary:subT.values()){
                    if(wordDictionary.search(word.substring(1))){
                        return true;
                    }
                }
                return false;
            }else{
                return subT.get(ch).search(word.substring(1));
            }

        }
    }
}
