package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 通过次数54,689提交次数92,423
 * */
public class EditDistance {

    @Test
    public void test(){
        Assert.assertEquals(6,minDistance("plasma","altruism"));
        Assert.assertEquals(3,minDistance("horse","ros"));
        Assert.assertEquals(5,minDistance("intention","execution"));
    }

    /**自底向上*/
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=dp[i-1][0]+1;;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=dp[0][j-1]+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    /**
     * 动态规划
     * dp[i][j] 表示 word1[i] 到word2[j] 的最短路径
     * word1[i]==word2[j] 时，有 dp[i]j]=dp[i-1][j-1]
     * 不等时,dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     *
     * 自顶向下
     * */
    public int minDistance2(String word1, String word2) {
        Integer[][] dp=new Integer[word1.length()][word2.length()];
        return dfs(dp,word1.length()-1,word2.length()-1,word1,word2);
//        return dp[word1.length()-1][word2.length()-1];
    }

    public int dfs(Integer[][] dp,int i,int j,String word1,String word2){
        if(i<0&&j<0){
            return 0;
        }
        if(i<0||j<0){
            return 1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=dfs(dp,i-1,j-1,word1,word2);
            return dp[i][j];
        }else{
            int delete=dfs(dp,i-1,j,word1,word2);
            int add=dfs(dp,i,j-1,word1,word2);
            int replace=dfs(dp,i-1,j-1,word1,word2);
            int min=Math.min(delete,add);
//            System.out.println(">>>>>>>>>");
//            System.out.println("i:"+i+"  j:"+j);
//            System.out.println("delete: "+delete+"  add "+add+"  replace: "+replace);
//            System.out.println("min: "+(min+1));
            min=Math.min(min,replace);
            dp[i][j]=min+1;
            return dp[i][j];
        }
    }


}
