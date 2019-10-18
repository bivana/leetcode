package com.ivan.leetcode;

import junit.framework.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * */
public class ValidParentheses {

    public static void main(String[] args){
        ValidParentheses validParentheses=new ValidParentheses();
        Assert.assertEquals(false,validParentheses.isValid("(})"));

        Assert.assertEquals(false,validParentheses.isValid("}"));
        Assert.assertEquals(true,validParentheses.isValid("()"));
        Assert.assertEquals(true,validParentheses.isValid("()[]{}"));
        Assert.assertEquals(false,validParentheses.isValid("(]"));
        Assert.assertEquals(false,validParentheses.isValid("([)]"));
        Assert.assertEquals(true,validParentheses.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> list=new LinkedList<Character>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='['||c=='{'){
                list.add(c);
            }else if(c== ')' || c==']' || c=='}'){
                if(list.size()==0){
                    return false;
                }
                Character f=list.getLast();
                if(c==')'){
                    if(f=='('){
                        list.removeLast();
                    }else{
                        return false;
                    }
                }else if(c=='}'){
                    if(f=='{'){
                        list.removeLast();
                    }else{
                        return false;
                    }
                }else if(c==']'){
                    if(f=='['){
                        list.removeLast();
                    }else{
                        return false;
                    }
                }
            }
        }
        return list.size()==0;
    }
}
