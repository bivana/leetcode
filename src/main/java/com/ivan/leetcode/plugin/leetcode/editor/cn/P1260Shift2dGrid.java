package com.ivan.leetcode.plugin.leetcode.editor.cn;//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//
// P1260 每次「迁移」操作将会引发下述活动：
//
// 
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
// 
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 73 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1260Shift2dGrid{


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            for(int z=0;z<k;z++){

                int[] tmp=new int[grid.length];
                for(int i=0;i<grid.length;i++){
                    tmp[i]=grid[i][grid[i].length-1];
                }
                //位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
                for(int i=0;i<grid.length;i++){
                    for(int j=grid[i].length-1;j>=1;j--){
                        grid[i][j]=grid[i][j-1];
                    }
                }
                //位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
                for(int i=1;i<grid.length;i++){
                    grid[i][0]=tmp[i-1];
                }
                //位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
                grid[0][0]=tmp[tmp.length-1];
            }
            List<List<Integer>> ans=new ArrayList<>();
            for(int i=0;i<grid.length;i++){
                List<Integer> list=new ArrayList();
                for(int j=0;j<grid[i].length;j++){
                    list.add(grid[i][j]);
                }
                ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}