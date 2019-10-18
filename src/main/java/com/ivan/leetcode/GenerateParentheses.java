package com.ivan.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * */
public class GenerateParentheses {

    @Test
    public void test(){
        List<String> l=generateParenthesis(3);
        for(String s:l){
            System.out.println(s);
        }
    }


    List<String> result;

    public List<String> generateParenthesis(int n) {
        result=new ArrayList<String>();
        generateParenthesis("",n,0);
        return result;
    }

    public List<String> generateParenthesis(String s,int n,int count){
        if(s.length()==n*2 && count==0){
            result.add(s);
            return result;
        }else if(s.length()<n*2){
            if(count<=n && count>=0){
                if(count<n){
                    generateParenthesis(s+"(",n,count+1);
                }
                if(count>0){
                    generateParenthesis(s+")",n,count-1);
                }
            }
        }
        return result;
    }
}
