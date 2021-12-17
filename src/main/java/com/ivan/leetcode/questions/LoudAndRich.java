package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 851. 喧闹和富有
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 *
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 *
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 * 示例 2：
 *
 * 输入：richer = [], quiet = [0]
 * 输出：[0]
 *
 * 提示：
 *
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值 互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对 互不相同
 * 对 richer 的观察在逻辑上是一致的
 * */
public class LoudAndRich {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{5,5,2,5,4,5,6,7},loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},new int[]{3,2,5,4,6,1,7,0}));
        Assert.assertArrayEquals(new int[]{0},loudAndRich(new int[][]{},new int[]{0}));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //>>>>>>>>>>>>>>>>>>>>构图操作
        int[] ans=new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            ans[i] = i;//初始化答案，默认答案为x，不少于即>=x，即保底为x,其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）,
        }
        List<Integer>[] outDeg=new ArrayList[quiet.length];//出度保存
        for(int i=0;i<outDeg.length;i++){
            outDeg[i]=new ArrayList<>();
        }
        int[] inDeg=new int[quiet.length];//入度保存
        //初始化入度，出度
        for(int[] con:richer){
            outDeg[con[0]].add(con[1]);//存入出度,因为题目是求不小于，即>=，因此得从大的作为入度，而非小的
            inDeg[con[1]]++;//存入入度
        }
        //>>>>>>>>>>>>>>>>>>>>解图操作
        Queue<Integer> queue=new ArrayDeque<>();
        //将入度为0的放入队列
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                queue.offer(i);
            }
        }
        //从队列中拿出数据
        while (!queue.isEmpty()){
            int x=queue.poll();
            //拿出x对应的所有出度
            for(int y:outDeg[x]){//x<y
                //如果出度为0，那么放入队列
                if(--inDeg[y]==0){
                    queue.offer(y);
                }
                //如果出度的安静值小于当前安静值，根据题意，求最小安静值，那么更新出度那个值的答案
                if(quiet[ans[x]]<quiet[ans[y]]){
                    ans[y]=ans[x];
                }
            }
        }

        return ans;
    }

//    public int[] loudAndRich(int[][] richer, int[] quiet) {
//        int n = quiet.length;
//        List<Integer>[] g = new List[n];//存储关系队列
//        for (int i = 0; i < n; ++i) {
//            g[i] = new ArrayList<>();
//        }
//        int[] inDeg = new int[n];
//        for (int[] r : richer) {
//            g[r[0]].add(r[1]);//g[大].add[小]
//            ++inDeg[r[1]];//入度+1
//        }
//
//        //起始时，每个 ans[i] = ians[i]=i
//        int[] ans = new int[n];
//        for (int i = 0; i < n; ++i) {
//            ans[i] = i;
//        }
//        //将统计入度为 00 的节点进行入队
//        Queue<Integer> q = new ArrayDeque<>();
//        for (int i = 0; i < n; ++i) {
//            if (inDeg[i] == 0) {
//                q.offer(i);
//            }
//        }
//        //每次出队时，将该节点删掉，对该 DAG 带来影响是「该节点的邻点的入度减一」，若更新入度后数值为 00，则将该邻点进行入队操作
//        //同时，利用跑拓扑排序过程中的 t -> ut−>u 关系，尝试使用 ans[t]ans[t] 更新 ans[u]ans[u]（由于存在 tt 指向 uu 的边，说明 tt 比 uu 有钱，此时检查两者的安静值，若满足 quiet[ans[t]] < quiet[ans[u]]quiet[ans[t]]<quiet[ans[u]]，则用 ans[t]ans[t] 更新 ans[u]ans[u]）。
//        while (!q.isEmpty()) {
//            int x = q.poll();
//            for (int y : g[x]) {//取的是所有比x值小的值
//                if (quiet[ans[x]] < quiet[ans[y]]) {
//                    ans[y] = ans[x]; // 更新 x 的邻居的答案
//                }
//                if (--inDeg[y] == 0) {
//                    q.offer(y);
//                }
//            }
//        }
//        return ans;
//    }
}
