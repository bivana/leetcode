package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * 通过次数76,862提交次数170,820
 * */
public class FirstUniqueCharacterInAString {

    @Test
    public void test(){
        Assert.assertEquals(0,firstUniqChar("leetcode"));
        Assert.assertEquals(2,firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] dp=new int[26];
        for(char c:s.toCharArray()){
            dp[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(dp[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
