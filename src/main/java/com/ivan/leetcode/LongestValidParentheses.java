package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * */
public class LongestValidParentheses {

    @Test
    public void test(){
        Assert.assertEquals(2,longestValidParentheses("(()"));
        Assert.assertEquals(4,longestValidParentheses(")()())"));
    }

    /**
     * 左右指针法
     * */
    public int longestValidParentheses(String s) {
        int max=0;
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            } else {
                right++;
            }
            if(left==right){
                max=Math.max(max,right*2);
            }else if(right>left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                max=Math.max(max,left*2);
            }else if(left>right){
                left=0;
                right=0;
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     * */
    public int longestValidParentheses3(String s) {
        int max=0;
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }

    /**
     * 堆栈解法
     * */
    public int longestValidParentheses2(String s) {
        int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
