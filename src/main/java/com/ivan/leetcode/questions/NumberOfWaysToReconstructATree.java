package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1719. 重构一棵树的方案数
 * 给你一个数组 pairs ，其中 pairs[i] = [xi, yi] ，并且满足：
 *
 * pairs 中没有重复元素
 * xi < yi
 * 令 ways 为满足下面条件的有根树的方案数：
 *
 * 树所包含的所有节点值都在 pairs 中。
 * 一个数对 [xi, yi] 出现在 pairs 中 当且仅当 xi 是 yi 的祖先或者 yi 是 xi 的祖先。
 * 注意：构造出来的树不一定是二叉树。
 * 两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。
 *
 * 请你返回：
 *
 * 如果 ways == 0 ，返回 0 。
 * 如果 ways == 1 ，返回 1 。
 * 如果 ways > 1 ，返回 2 。
 * 一棵 有根树 指的是只有一个根节点的树，所有边都是从根往外的方向。
 *
 * 我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的 祖先 。根节点没有祖先。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：pairs = [[1,2],[2,3]]
 * 输出：1
 * 解释：如上图所示，有且只有一个符合规定的有根树。
 * 示例 2：
 *
 *
 * 输入：pairs = [[1,2],[2,3],[1,3]]
 * 输出：2
 * 解释：有多个符合规定的有根树，其中三个如上图所示。
 * 示例 3：
 *
 * 输入：pairs = [[1,2],[2,3],[2,4],[1,5]]
 * 输出：0
 * 解释：没有符合规定的有根树。
 *
 *
 * 提示：
 *
 * 1 <= pairs.length <= 105
 * 1 <= xi < yi <= 500
 * pairs 中的元素互不相同。
 * */
public class NumberOfWaysToReconstructATree {

    @Test
    public void test(){
        Assert.assertEquals(1,checkWays(new int[][]{{1,2},{2,3}}));
        Assert.assertEquals(2,checkWays(new int[][]{{1,2},{2,3},{1,3}}));
        Assert.assertEquals(0,checkWays(new int[][]{{1,2},{2,3},{2,4},{1,5}}));
    }

    public int checkWays(int[][] pairs) {
        int ans=0;
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[] pair:pairs){
            if(map.get(pair[0])==null){
                map.put(pair[0],new HashSet<>());
            }
            if(map.get(pair[1])==null){
                map.put(pair[1],new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        List<Map.Entry<Integer,Set<Integer>>> list=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list,(a,b)->Integer.valueOf(b.getValue().size()).compareTo(Integer.valueOf(a.getValue().size())));
        ans=checkWays(new ArrayList<>(),map,list);
        return ans>1?2:ans;
    }

    //递归获取
    public int checkWays(List<Integer> preNode,Map<Integer,Set<Integer>> memo,List<Map.Entry<Integer,Set<Integer>>> list){
        List<Integer> node=new ArrayList<>(preNode);
        int ans=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getValue().size()>=(memo.size()-node.size()-1)){
                node.add(list.get(i).getKey());
                if(node.size()==memo.size()){
                    ans++;
                }else{
                    ans+=checkWays(node,memo,list.subList(i+1,list.size()));
                }
                if(ans>1){
                    return ans;
                }
            }else{
                break;
            }
        }
        return ans;
    }
}
