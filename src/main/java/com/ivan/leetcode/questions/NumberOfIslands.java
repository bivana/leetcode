package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 200. 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 * */
public class NumberOfIslands {

    @Test
    public void test(){
        Assert.assertEquals(1,numIslands(new char[][]{
                                                                {'1','1','1','1','0'}
                                                                ,{'1','1','0','1','0'}
                                                                ,{'1','1','0','0','0'}
                                                                ,{'0','0','0','0','0'}}));
        Assert.assertEquals(3,numIslands(new char[][]{{'1','1','0','0','0'}
                                                                ,{'1','1','0','0','0'}
                                                                ,{'0','0','1','0','0'}
                                                                ,{'0','0','0','1','1'}}));
    }

    class UnionFind {
        int count; // # of connected components
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) { // for problem 200
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) { // path compression
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) { // union with rank
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx; rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    //深度优先法

//    public void findIsland(char[][] grid,int i,int j){
//        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
//            return;
//        }
//        grid[i][j]='0';
//        findIsland(grid,i-1,j);
//        findIsland(grid,i+1,j);
//        findIsland(grid,i,j-1);
//        findIsland(grid,i,j+1);
//    }
//
//    public int numIslands(char[][] grid) {
//        if(grid==null || grid.length==0){
//            return 0;
//        }
//        int count=0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]=='1'){
//                    count++;
//                    findIsland(grid,i,j);
//                }
//            }
//        }
//        return count;
//    }




}
