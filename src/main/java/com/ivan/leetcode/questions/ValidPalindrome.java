package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * */
public class ValidPalindrome {

    @Test
    public void test(){
        Assert.assertEquals(true,isPalindrome(".,"));
        Assert.assertEquals(true,isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false,isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while (left<right){
            while (  !isllegalChar(getChar(s.charAt(left)))){
                if(++left>=s.length()){
                    return true;
                }
            }
            while (!isllegalChar(getChar(s.charAt(right)))){
                if(--right<0){
                    return true;
                }
            }
            if(getChar(s.charAt(left++))!=getChar(s.charAt(right--))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char c='a';
        if(c>=97 && c<=122){
            System.out.println((char)(c-32)+"");;
        }
    }

    private char getChar(char c){
        if(c>=97 && c<=122){
            return (char)(c-32);
        }
        return c;
    }

    private boolean isllegalChar(char c){
        if(c>=48 && c<=57){
            return true;
        }else if(c>=65 && c<=90){
            return true;
        }else if(c>=97 && c<=122){
            return true;
        }
        return false;
    }
}
