package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * */
public class ReverseWordsInAString3 {

    @Test
    public void test(){
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if(s==null||"".equals(s)){
            return s;
        }
        char[] c=s.toCharArray();
        int start=0;
        int end=0;
        while (end<c.length){
            for(int i=start;i<c.length;i++){
                if(c[i]==' '){
                    end=i-1;
                    break;
                }else{
                    end=i;
                }
            }
            int tempStart=start;
            int tempEnd=end;
            while (tempEnd>tempStart){
                char temp=c[tempStart];
                c[tempStart]=c[tempEnd];
                c[tempEnd]=temp;
                tempEnd--;
                tempStart++;
            }
            start=end+2;
            end=start;
        }
        return new String(c);
    }
}
