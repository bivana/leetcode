package com.ivan.leetcode.plugin.leetcode.editor.cn;
// 757. 设置交集大小至少为2
// 一个整数区间 [a, b] ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
//
// 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。 
//
// 输出这个最小集合S的大小。 
//
// 示例 1: 
//
// 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
//输出: 3
//解释:
//考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
//且这是S最小的情况，故我们输出3。
// 
//
// 示例 2: 
//
// 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
//输出: 5
//解释:
//最小的集合S = {1, 2, 3, 4, 5}.
// 
//
// 注意: 
//
// 
// intervals 的长度范围为[1, 3000]。 
// intervals[i] 长度为 2，分别代表左、右边界。 
// intervals[i][j] 的值是 [0, 10^8]范围内的整数。 
// 
// Related Topics 贪心 数组 排序 👍 95 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P757SetIntersectionSizeAtLeastTwo{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(6,solution.intersectionSizeTwo(new int[][]{{33,44},{42,43},{13,37},{24,33},{24,33},{25,48},{10,47},{18,24},{29,37},{7,34}}));

        Assert.assertEquals(4,solution.intersectionSizeTwo(new int[][]{{4,14},{6,17},{7,14},{14,21},{4,7}}));
        Assert.assertEquals(5,solution.intersectionSizeTwo(new int[][]{{1,3},{3,7},{5,7},{7,8}}));
        Assert.assertEquals(5,solution.intersectionSizeTwo(new int[][]{{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}}));
        Assert.assertEquals(3,solution.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        Assert.assertEquals(5,solution.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]){
                        return Integer.valueOf(o2[0]).compareTo(o1[0]);
                    }
                    return Integer.valueOf(o1[1]).compareTo(o2[1]);
                }
            });
            int ans=0;
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<intervals.length;i++){
                int[] interval=intervals[i];
                if(list.size()==0||list.get(list.size()-1)<interval[0]){//初始化或一个交集都没有
                    //计数并清空
                    ans+=list.size();
                    list=new ArrayList<>();
                    list.add(interval[1]-1);
                    list.add(interval[1]);
                }else if (list.get(list.size()-2)>=interval[0]&&list.get(list.size()-1)<=interval[1]){//子集
                    continue;
//                }else if( list.get(list.size()-1)==interval[0]){//一个交集
                }else {//一个交集
                    //如果这一个和下一个有交集，那么放入最后面那个
                    if(i<intervals.length-1&&interval[1]>=intervals[i+1][0]){
                        list.add(interval[1]);
                    }else{
                        list.add(interval[0]+1);
                    }
                }
            }
            ans+=list.size();
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
