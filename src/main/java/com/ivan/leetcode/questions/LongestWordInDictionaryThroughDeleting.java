package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","aplea"]
 * 输出："apple"
 * 示例 2：
 * applaaaapple
 * apple
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LongestWordInDictionaryThroughDeleting {

    @Test
    public void test(){
        Assert.assertEquals(findLongestWord("apple", Arrays.asList(new String[]{"zxc","vbn"})),"");
        Assert.assertEquals(findLongestWord("aaa", Arrays.asList(new String[]{"aaa","aa"})),"a");
        Assert.assertEquals(findLongestWord("abce", Arrays.asList(new String[]{"abe","abc"})),"abc");
        Assert.assertEquals(findLongestWord("abpcplea", Arrays.asList(new String[]{"ale","apple","monkey","plea"})),"apple");
        Assert.assertEquals(findLongestWord("abpcplea", Arrays.asList(new String[]{"a","b","c"})),"a");

    }

    public String findLongestWord(String s, List<String> dictionary) {
        if(s==null||"".equals(s)){
            return null;
        }
        if(dictionary==null||dictionary.size()==0){
            return null;
        }
        String rs="";
        for(String singleDictionary:dictionary){
            if(isMatch(s,singleDictionary)){
                if(rs.length()<singleDictionary.length()){
                    rs=singleDictionary;
                }else if(rs.length()==singleDictionary.length() && rs.compareTo(singleDictionary)>0){
                    rs=singleDictionary;
                }
            }
        }
        return rs;
    }

    private boolean isMatch(String s, String singleDictionary) {
        int i=0;
        int j=0;
        while (j<s.length()){
            if(singleDictionary.charAt(i)==s.charAt(j)){
                if(i==singleDictionary.length()-1){
                    return true;
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
