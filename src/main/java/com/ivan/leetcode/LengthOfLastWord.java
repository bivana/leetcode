package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * */
public class LengthOfLastWord {

    @Test
    public void test(){
        Assert.assertEquals(1,lengthOfLastWord("a "));

        Assert.assertEquals(5,lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int c=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(c!=0){
                    break;
                }

            }else{
                c++;
            }
        }
        return c;
    }

}
