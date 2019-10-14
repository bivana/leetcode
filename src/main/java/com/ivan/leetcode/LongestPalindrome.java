package com.ivan.leetcode;

public class LongestPalindrome {

    public static void main(String[] args){
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        String s="abcda";
        String palindrome=longestPalindrome.longestPalindrome(s);
        System.out.println(palindrome);
    }

    public String longestPalindrome(String s) {
        Integer[] mark=new Integer[256];
        int startIndex=0;
        int endIndex=0;
        int length=0;
        for(int i=0;i<s.length();i++){
            if(mark[s.charAt(i)]==null){
                mark[s.charAt(i)]=i;
            }else{
                int curLength=i-mark[s.charAt(i)];
                if(curLength>length){
                    length=curLength;
                    startIndex=mark[s.charAt(i)];
                    endIndex=i;
                }
            }
        }
        if(length==0){
            if(s.length()>0){
                return s.substring(0,1);
            }
            return "";
        }
        return s.substring(startIndex,endIndex+1);
    }
}
