package com.ivan.leetcode.plugin.leetcode.editor.cn;
//675 为高尔夫比赛砍树
//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中： 
//
// 
// 0 表示障碍，无法触碰 
// 1 表示地面，可以行走 
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。 
//
// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
//输出：6
//解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。 
//
// 示例 2： 
//
// 
//输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
//输出：-1
//解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
// 
//
// 示例 3： 
//
// 
//输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
//输出：6
//解释：可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
// 
//
// 
//
// 提示： 
//
// 
// m == forest.length 
// n == forest[i].length 
// 1 <= m, n <= 50 
// 0 <= forest[i][j] <= 10⁹ 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 133 👎 0

import com.ivan.leetcode.util.CreateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P675CutOffTreesForGolfEvent{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(57,solution.cutOffTree(CreateUtil.createIntegerMatrix(new Integer[][]{{54581641,64080174,24346381,69107959}
                ,{86374198,61363882,68783324,79706116}
                ,{668150,92178815,89819108,94701471}
                ,{83920491,22724204,46281641,47531096}
                ,{89078499,18904913,25462145,60813308}})));

        Assert.assertEquals(6,solution.cutOffTree(CreateUtil.createIntegerMatrix(new Integer[][]{{1,2,3},{0,0,4},{7,6,5}})));
        Assert.assertEquals(-1,solution.cutOffTree(CreateUtil.createIntegerMatrix(new Integer[][]{{1,2,3},{0,0,0},{7,6,5}})));
        Assert.assertEquals(6,solution.cutOffTree(CreateUtil.createIntegerMatrix(new Integer[][]{{2,3,4},{0,0,5},{8,7,6}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int N = 50;
        int[][] g = new int[N][N];
        int n, m;
        List<int[]> list = new ArrayList<>();
        public int cutOffTree(List<List<Integer>> forest) {
            n = forest.size(); m = forest.get(0).size();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    g[i][j] = forest.get(i).get(j);
                    if (g[i][j] > 1) list.add(new int[]{g[i][j], i, j});
                }
            }
            if (g[0][0] == 0) return -1;
            Collections.sort(list, (a,b)->a[0]-b[0]);
            int x = 0, y = 0, ans = 0;
            for (int[] ne : list) {
                int nx = ne[1], ny = ne[2];
                int d = astar(x, y, nx, ny);
                if (d == -1) return -1;
                ans += d;
                x = nx; y = ny;
            }
            return ans;
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int getIdx(int x, int y) {
            return x * m + y;
        }
        int f(int X, int Y, int P, int Q) {
            return Math.abs(X - P) + Math.abs(Y - Q);
        }
        int astar(int X, int Y, int P, int Q) {
            if (X == P && Y == Q) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
            q.add(new int[]{f(X, Y, P, Q), X, Y});
            map.put(getIdx(X, Y), 0);
            while (!q.isEmpty()) {
                int[] info = q.poll();
                int x = info[1], y = info[2], step = map.get(getIdx(x, y));
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1], nidx = getIdx(nx, ny);
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (g[nx][ny] == 0) continue;
                    if (nx == P && ny == Q) return step + 1;
                    if (!map.containsKey(nidx) || map.get(nidx) > step + 1) {
                        q.add(new int[]{step + 1 + f(nx, ny, P, Q), nx, ny});
                        map.put(nidx, step + 1);
                    }
                }
            }
            return -1;
        }


//    public int cutOffTree(List<List<Integer>> forest) {
//        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
//        for(int i=0;i<forest.size();i++){
//            for(int j=0;j<forest.get(i).size();j++){
//                if(forest.get(i).get(j)>1){
//                    priorityQueue.add(forest.get(i).get(j));
//                }
//            }
//        }
//        int[] cur=new int[]{0,0};
//
//        int ans=0;
//        while (!priorityQueue.isEmpty()){
//            int[] tmp=bfs(forest,cur,priorityQueue.poll());
//            if(tmp[2]==-1){
//                return -1;
//            }
//            ans+=tmp[2];
//            cur[0]=tmp[0];
//            cur[1]=tmp[1];
//        }
//        return ans;
//    }
//
//    boolean[][] dp;
//    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//
//    //广度优先遍历
//    public int[] bfs(List<List<Integer>> forest,int[] cur,int target){
//        //第一步就是目标
//        if(forest.get(cur[0]).get(cur[1])==target){
//            return new int[]{cur[0],cur[1],0};
//        }
//        int ans=0;
//        dp=new boolean[forest.size()][forest.get(0).size()];
////        dp[0][0]=true;
//        Deque<int[]> deque=new ArrayDeque<>();
//        deque.add(cur);
//        int steps=0;//当前步数
//        while (!deque.isEmpty()){//循环
//            int length=deque.size();//广播长度
//            steps++;
//            for(int i=0;i<length;i++){
//                int[] position=deque.poll();
//                for(int d=0;d<directions.length;d++){
//                    int[] next=new int[]{position[0]+directions[d][0],position[1]+directions[d][1]};
//                    if(next[0]>=0&&next[0]<forest.size()&&next[1]>=0&&next[1]<forest.get(0).size()&&!dp[next[0]][next[1]]){
//                        int value=forest.get(next[0]).get(next[1]);
//                        if(value==target){
//                            return new int[]{next[0],next[1],steps};
//                        }
//                        if(value!=0){
//                            deque.add(next);
//                        }
//                        dp[next[0]][next[1]]=true;
//                    }
//                }
//            }
//        }
//
//        return new int[]{-1,-1,-1};
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}