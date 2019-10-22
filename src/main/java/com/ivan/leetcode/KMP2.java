package com.ivan.leetcode;

public class KMP2 {
    private String pat;
    private int[][] dp;
    public KMP2(String pattern){
        this.pat=pattern;
        dp=new int[pat.length()][256];
        dp[0][pat.charAt(0)]=1;
        int x=0;
        for(int i=1;i<pat.length();i++){
            for(int j=0;j<256;j++){
                dp[i][j]=dp[x][j];
                dp[i][pat.charAt(j)]=i+1;
                x=dp[x][pat.charAt(j)];
            }
        }
    }

    public int search(String text){
        int j=0;
        for(int i=0;i<text.length();i++){
            j=dp[j][text.charAt(i)];
            if(j==pat.length()){
                return i-pat.length()+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String s="abc";
        System.out.println(s.charAt(1));
    }
}
