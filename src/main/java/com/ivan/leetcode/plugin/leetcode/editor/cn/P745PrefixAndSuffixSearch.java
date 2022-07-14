package com.ivan.leetcode.plugin.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 745. 前缀和后缀搜索
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 *
 * 实现 WordFilter 类：
 *
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 *
 *
 * 示例：
 *
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 * 通过次数8,570提交次数19,104
 * */
public class P745PrefixAndSuffixSearch {

    @Test
    public void test(){
        WordFilter wordFilter4=new WordFilter(new String[]{"c","c","c","i","c","c","c","c","c","i","c","c","c","c","c","i","c","i","c","c","c","c","c","c","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","c","i","c","c","c","c","i","i","c","c","c","c","c","c","c","c","i","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","c","i","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","i","c","c","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","c","i","i","c","c","c","c","c","i","c","i","c","i","c","i","c","i","c","c","c","c","c","c","c","c","c","i","c","c","c","c","c","i","c","c","c","c","c","c","c","c","c","i","c","c","i","c","c","c","c","c","i","c"});
        Assert.assertEquals(9999,wordFilter4.f("c","c"));

        WordFilter wordFilter3=new WordFilter(new String[]{"abbba","abba"});
        Assert.assertEquals(1,wordFilter3.f("ab","ba"));

        WordFilter wordFilter=new WordFilter(new String[]{"apple"});
        Assert.assertEquals(-1,wordFilter.f("b","e"));

        WordFilter wordFilter2=new WordFilter(new String[]{"apple"});
        Assert.assertEquals(0,wordFilter2.f("a","e"));
    }

    class WordFilter {

        TireTree asc=new TireTree();
        TireTree desc=new TireTree();

        public WordFilter(String[] words) {
            for(int i=0;i<words.length;i++){
                asc.add(words[i],i);
                StringBuilder sb=new StringBuilder(words[i]);
                desc.add(sb.reverse().toString(),i);
            }
        }

        public int f(String pref, String suff) {
            List<Integer> l1=asc.search(pref);
            StringBuilder sb=new StringBuilder(suff);
            List<Integer> l2=desc.search(sb.reverse().toString());
            if(l1==null||l2==null){
                return -1;
            }
            int i=l1.size()-1;
            int j=l2.size()-1;
            while (i>=0&&j>=0){
                if(l1.get(i).equals(l2.get(j))){
                    return l1.get(i);
                }else if(l1.get(i)>l2.get(j)){
                    i--;
                }else{
                    j--;
                }
            }
            return -1;
        }
    }

    class TireTree{

        Map<Character,TireTree> map=new HashMap<>();
        List<Integer> indexList=new ArrayList<>();

        Character val=null;

        boolean isWord=false;

        public void add(String word,int index){
            if(word==null||"".equals(word)){
                return;
            }
            TireTree cur=this;
            for(Character c:word.toCharArray()){
                if(cur.map.get(c)==null){
                    TireTree sub=new TireTree();
                    sub.val=c;

                    cur.map.put(c,sub);
                }
                cur=cur.map.get(c);
                cur.indexList.add(index);
            }
            cur.isWord=true;
        }

        public List<Integer> search(String str){
            TireTree cur=this;
            for(Character c:str.toCharArray()){
                cur=cur.map.get(c);
                if(cur==null){
                    return null;
                }
            }
            return cur.indexList;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
}
