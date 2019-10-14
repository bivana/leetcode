package com.ivan.leetcode;

/**
 * 第五题 最长回文字符串
 *
 * 所谓回文，就是正着读，倒着读一样的字符串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LongestPalindrome {

    public static void main(String[] args){
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        String s="ababaabc";
//        String res=longestPalindrome.longestPalindrome(s);
        String res=longestPalindrome.longestPalindromeManacher(s);

        System.out.println(res);
    }

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindromeManacher(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome(String s) {
        String longestPalindrome="";
        for(int i=0;i<s.length();i++){
            int even=getLongestPalindrome(s,i,i+1);
            int odd=getLongestPalindrome(s,i,i);
            if((odd-1)*2+1>longestPalindrome.length()){
                longestPalindrome=s.substring(i-odd+1,i+odd);
            }
            if(even*2>longestPalindrome.length()){
                longestPalindrome=s.substring(i-even+1,i+even+1);
            }
        }
        return  longestPalindrome;

    }

    private int getLongestPalindrome(String s,int left,int right){
        int k=0;
        while ( left>=0 &&right<=s.length()-1 && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
            k++;
        }
        return k;
    }
}
