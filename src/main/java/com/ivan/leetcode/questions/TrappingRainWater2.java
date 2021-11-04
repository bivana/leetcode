package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * 示例 2:
 *
 *
 *
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *
 *
 * 提示:
 *
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 * */
public class TrappingRainWater2 {
    @Test
    public void test(){
        Assert.assertEquals(4,trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        Assert.assertEquals(10,trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));

    }

    // 最小堆
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];

        // 队列，先进先出,优先级队列是为了求边
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {//边缘
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});//先把周围的一圈，二维数组一维化，让后放入队列
                    visit[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int k = 0; k < 4; ++k) {
                int nx = curr[0] / n + dirs[k];//从一维变回2维，并向四周广度遍历
                int ny = curr[0] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {//在圈内，且未被访问过
                    if (curr[1] > heightMap[nx][ny]) {// 由于拿出的外围已经是最低的外围了，如果新点位比外围低，那么就可以蓄水
                        res += curr[1] - heightMap[nx][ny];//结果加上新点位可以蓄水的点位
                    }
                    pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});//将访问过的点位放入优先级队列
                    visit[nx][ny] = true;
                }
            }
        }
        return res;
    }

    // 广度优先遍历
//    public int trapRainWater(int[][] heightMap) {
//        int m = heightMap.length;
//        int n = heightMap[0].length;
//        int[] dirs = {-1, 0, 1, 0, -1};
//        int maxHeight = 0;
//
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                maxHeight = Math.max(maxHeight, heightMap[i][j]);
//            }
//        }
//        int[][] water = new int[m][n];
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j){
//                water[i][j] = maxHeight;
//            }
//        }
//        Queue<int[]> qu = new LinkedList<>();
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
//                    if (water[i][j] > heightMap[i][j]) {
//                        water[i][j] = heightMap[i][j];
//                        qu.offer(new int[]{i, j});
//                    }
//                }
//            }
//        }
//        while (!qu.isEmpty()) {
//            int[] curr = qu.poll();
//            int x = curr[0];
//            int y = curr[1];
//            for (int i = 0; i < 4; ++i) {
//                int nx = x + dirs[i], ny = y + dirs[i + 1];
//                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
//                    continue;
//                }
//                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
//                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
//                    qu.offer(new int[]{nx, ny});
//                }
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                res += water[i][j] - heightMap[i][j];
//            }
//        }
//        return res;
//    }
}
