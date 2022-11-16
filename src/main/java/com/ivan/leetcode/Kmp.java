package com.ivan.leetcode;

public class Kmp {

    //next[i]表示长度为n的多少前缀等于后缀
    private int[] next;

    private String pattern;

    public Kmp(String pattern){
        this.pattern=pattern;
        buildNext(pattern);
    }

    private void buildNext(String pattern){
        next=new int[pattern.length()];
        next[0]=0;
        int pos=0;
        int i=1;
        while (i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(pos)){
                pos++;
                next[i]=pos;
                i++;
            }else if(pos!=0){
                pos=next[pos-1];
            }else{
                next[i]=pos;
                i++;
            }
        }
    }

    public int search(String word){
        int index=-1;
        int j=0;
        for(int i=0;i<word.length();i++){
            while (j<pattern.length()){
                if(word.charAt(i)==pattern.charAt(j)){
                    j++;
                    i++;
                }else if(j==0){//字符不一样时
                    break;
                }else{
                    j=next[j-1];
                }
            }
            if(j==pattern.length()){
                return i-pattern.length();
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Kmp kmp=new Kmp("abab");
        System.out.println(kmp.search("sdfababdf"));
        System.out.println(kmp.search("abab"));
        System.out.println(kmp.search("abac"));
        System.out.println(kmp.search("cabab"));
    }

}
