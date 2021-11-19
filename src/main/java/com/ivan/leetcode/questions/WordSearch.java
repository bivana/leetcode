package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 通过次数42,319提交次数103,535
 * */
public class WordSearch extends TestAbstract{

    @Test
    public void test(){
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Assert.assertEquals(true,exist(board,"ABCCED"));
        Assert.assertEquals(true,exist(board,"SEE"));
        Assert.assertEquals(false,exist(board,"ABCB"));
    }

    /**
     * 递归法
     * */
    public boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0){
            return true;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backTrace(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(char[][] board,String word,int i,int j,int index,boolean[][] visited){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length) {
            if(!visited[i][j] && board[i][j]==word.charAt(index)){
                index++;
                visited[i][j]=true;
                if(index==word.length()){
                    return true;
                }
                if(backTrace(board,word,i+1,j,index,visited)||backTrace(board,word,i-1,j,index,visited)
                        || backTrace(board,word,i,j+1,index,visited)||backTrace(board,word,i,j-1,index,visited)){
                    return true;
                }
                //回溯
                if(visited[i][j]){
                    index--;
                    visited[i][j]=false;
                }
            }


            return false;
        }
        return false;
    }

}
