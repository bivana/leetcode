package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 * */
public class NQueens {

    @Test
    public void test(){
        List<List<String>> rs=solveNQueens(4);
        ShowUtil.showStringListMatrix(rs);
    }

    int n;// 表示N

    int[] queens;//皇后表示的位置，下标表示为行号，值表示为列, 同一行有皇后代表此行被攻击
    int[] columns;//表示列是否被攻击
    int[] main;//主对角线，主对角线的值有row+col相同的特征
    int[] seconary;//次次对角线
    List<List<String>> rs=new ArrayList<>();//结果

    private void placeQueen(int row,int col){
        queens[row]=col;
        columns[col]=1;
        main[row+col]=1;
        seconary[row-col+n-1]=1;
    }

    private void removeQueen(int row,int col){
        queens[row]=0;
        columns[col]=0;
        main[row+col]=0;
        seconary[row-col+n-1]=0;
    }

    private boolean isNotUnderAttack(int row,int col){
        int res=columns[col]+main[row+col]+seconary[row-col+n-1];
        return res==0?true:false;
    }

    private void addSolution(){
        List<String> solution=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<n;j++){
                if(queens[i]==j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }
        rs.add(solution);
    }

    private void backtrace(int row){
        for(int col=0;col<n;col++){
            if(isNotUnderAttack(row,col)){
                placeQueen(row,col);
                if(row+1==n){
                    addSolution();
//                    return;
                }else{
                    backtrace(row+1);
                }
                removeQueen(row,col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        this.queens=new int[n];
        this.columns=new int[n];
        this.main=new int[2*n-1];// row+col 最大值为 n-1+n-1 +1(0)
        this.seconary=new int[2*n-1];//row-col 最大值为n-1,最小值为 -(n-1) ,为了防止下表越出，同时加上n-1
        backtrace(0);
        return rs;
    }

}
