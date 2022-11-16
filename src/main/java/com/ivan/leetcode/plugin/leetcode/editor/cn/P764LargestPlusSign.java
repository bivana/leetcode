package com.ivan.leetcode.plugin.leetcode.editor.cn;
//764. 最大加号标志
// 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 138 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

public class P764LargestPlusSign{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(2,solution.orderOfLargestPlusSign(5,new int[][]{{4,2}}));
        Assert.assertEquals(0,solution.orderOfLargestPlusSign(1,new int[][]{{0,0}}));
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        System.out.println(sdf.format(new Date()));
        Date d1=sdf.parse("2022-12-05 22:54:54.0");
        System.out.println(d1);
        System.out.println(sdf.format(d1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int ans=0;
//            int[][] grid=new int[n][n];
//            for(int[] point:mines){
//                grid[point[0]][point[1]]=1;
//            }
//            int[][] directs=new int[][]{{0,1},{0,-1},{1,0},{1,-1}};
//            Queue<int[]> queue=new ArrayDeque<>();
//            queue.offer(new int[]{n/2,n/2});
//            while (!queue.isEmpty()){
//                int[] p=queue.poll();
//                if(grid[p[0]][p[1]]==1){
//                    for(int[] direct:directs){
//                        int[] nextP=new int[]{p[0]+direct[0],p[1]+direct[1]};
//                        if(grid[nextP[]])
//                    }
//                }
//            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
