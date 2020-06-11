package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * */
public class ValidAnagram {

    @Test
    public void test(){
        Assert.assertEquals(true,isAnagram("anagram","nagaram"));
        Assert.assertEquals(false,isAnagram("rat","car"));
    }

    public boolean isAnagram(String s, String t) {
        int[] sArray=new int[128];
        int[] tArray=new int[128];
        for(char sc:s.toCharArray()){
            sArray[sc]=sArray[sc]+1;
        }
        for(char tc:t.toCharArray()){
            tArray[tc]=tArray[tc]+1;
        }
        for(int i=0;i<=127;i++){
            if(sArray[i]!=tArray[i]){
                return false;
            }
        }
        return true;
    }
}
