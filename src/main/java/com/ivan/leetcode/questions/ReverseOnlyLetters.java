package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * */
public class ReverseOnlyLetters {

    @Test
    public void test(){
        Assert.assertEquals("?6E40C",reverseOnlyLetters("?6C40E"));
        Assert.assertEquals("dc-ba",reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba",reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!",reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String s) {
        char[] array=s.toCharArray();
        int l=0;
        int r=array.length-1;
        while (l<r){
            while (l<r&&!isLetter(array[l])){
                l++;
            }
            while (r>l&&!isLetter(array[r])){
                r--;
            }
            if(l<r){
                swap(array,l,r);
                l++;
                r--;
            }
        }
        return new String(array);
    }

    public void swap(char[] array,int i,int j){
        char tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public boolean isLetter(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
}
