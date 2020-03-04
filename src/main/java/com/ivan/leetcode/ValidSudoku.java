package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 36. 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * {
 *   {'5','3','.','.','7','.','.','.','.'},
 *   {'6','.','.','1','9','5','.','.','.'},
 *   {'.','9','8','.','.','.','.','6','.'},
 *   {'8','.','.','.','6','.','.','.','3'},
 *   {'4','.','.','8','.','3','.','.','1'},
 *   {'7','.','.','.','2','.','.','.','6'},
 *   {'.','6','.','.','.','.','2','8','.'},
 *   {'.','.','.','4','1','9','.','.','5'},
 *   {'.','.','.','.','8','.','.','7','9'}
 * }
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * {
 *   {'8','3','.','.','7','.','.','.','.'},
 *   {'6','.','.','1','9','5','.','.','.'},
 *   {'.','9','8','.','.','.','.','6','.'},
 *   {'8','.','.','.','6','.','.','.','3'},
 *   {'4','.','.','8','.','3','.','.','1'},
 *   {'7','.','.','.','2','.','.','.','6'},
 *   {'.','6','.','.','.','.','2','8','.'},
 *   {'.','.','.','4','1','9','.','.','5'},
 *   {'.','.','.','.','8','.','.','7','9'}
 * }
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * */
public class ValidSudoku {

    @Test
    public void test(){
        char[][] a=new char[][]{{'5','3','.','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                  {'.','9','8','.','.','.','.','6','.'},
                  {'8','.','.','.','6','.','.','.','3'},
                  {'4','.','.','8','.','3','.','.','1'},
                  {'7','.','.','.','2','.','.','.','6'},
                  {'.','6','.','.','.','.','2','8','.'},
                  {'.','.','.','4','1','9','.','.','5'},
                  {'.','.','.','.','8','.','.','7','9'}
                };
        char[][] b=new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        Assert.assertEquals(true,isValidSudoku(a));
        Assert.assertEquals(false,isValidSudoku(b));
    }

    public boolean isValidSudoku(char[][] board) {
        if(!checkCol(board)){
            return false;
        }
        if(!checkRow(board)){
            return false;
        }
        if(!checkArea(board)){
            return false;
        }

        return true;
    }

    public boolean checkArea(char[][] board){
        int[] set;
        int startRow=0;
        int endRow=2;
        int startCol=0;
        int endCol=2;
        while (endRow<=board.length && endCol<=board[0].length){
            set=new int[10];
            for(int row=startRow;row<=endRow;row++){

                for(int col=startCol;col<=endCol;col++){
                    if(board[row][col]=='.'){
                        continue;
                    }
                    int num=board[row][col]-'0';
                    if(set[num]==1){
                        return false;
                    }
                    set[num]=1;
                }
            }
            startCol=startCol+3;
            endCol=endCol+3;
            if(endCol>=board[0].length){
                startCol=0;
                endCol=2;
                startRow=startRow+3;
                endRow=endRow+3;
            }
        }

        return true;
    }

    public boolean checkRow(char[][] board){
        int[] set;
        for(int col=0;col<board[0].length;col++){
            set=new int[10];
            for(int row=0;row<board.length;row++){
                if(board[row][col]=='.'){
                    continue;
                }
                int num=board[row][col]-'0';
                if(set[num]==1){
                    return false;
                }
                set[num]=1;
            }
        }

        return true;
    }

    public boolean checkCol(char[][] board){
        int[] set;
        for(int row=0;row<board.length;row++){
            set=new int[10];
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]=='.'){
                    continue;
                }
                int num=board[row][col]-'0';
                if(set[num]==1){
                    return false;
                }
                set[num]=1;
            }
        }

        return true;
    }


}
