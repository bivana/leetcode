package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 通过次数27,138提交次数54,937
 * 在真实的面试中遇到过这道题？
 *
 * */
public class ReverseVowelsOfAString {

    @Test
    public void test(){
        Assert.assertEquals("holle",reverseVowels("hello"));
        Assert.assertEquals("leotcede",reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if(s==null || s.length()<=1){
            return s;
        }
        Set<Character> origin=new HashSet<>();
        origin.add('a');
        origin.add('e');
        origin.add('i');
        origin.add('o');
        origin.add('u');
        origin.add('A');
        origin.add('E');
        origin.add('I');
        origin.add('O');
        origin.add('U');
        char[] array=s.toCharArray();
        int start=0;
        int end=s.length()-1;
        while (start<end){
            while (start<end && !origin.contains(array[start])){
                start++;
            }
            while (start<end && !origin.contains(array[end])){
                end--;
            }
            if(start<end){
                char temp=array[start];
                array[start]=array[end];
                array[end]=temp;
                start++;
                end--;
            }
        }
        return new String(array);
    }

}
