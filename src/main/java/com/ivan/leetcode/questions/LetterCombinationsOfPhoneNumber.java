package com.ivan.leetcode.questions;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args){
        System.out.println(Character.getNumericValue("12".charAt(0)));
        LetterCombinationsOfPhoneNumber le=new LetterCombinationsOfPhoneNumber();
        List<String> l=le.letterCombinations("23");
        for(String s: l){
            System.out.println(s);
        }
    }

    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res;

    public List<String> letterCombinations(String digits) {
        res=new ArrayList<String>();
        if(digits==null||digits.length()==0){
            return res;
        };
        backTrace("",digits);
        return res;
    }

    public void backTrace(String combine,String nextDigits){
        if(nextDigits.length()==0){
            res.add(combine);
            return;
        }
        int i=Integer.parseInt(nextDigits.substring(0,1));
        for(char c:mapping[i].toCharArray()){
            backTrace(combine+c,nextDigits.substring(1));
        }
    }


//
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<String>();
//        if(digits==null||digits.length()==0){
//            return ans;
//        };
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        for(int i =0; i<digits.length();i++){
//            int x = Character.getNumericValue(digits.charAt(i));
//            while(ans.peek().length()==i){
//                String t = ans.remove();
//                for(char s : mapping[x].toCharArray())
//                    ans.add(t+s);
//            }
//        }
//        return ans;
//    }
}
