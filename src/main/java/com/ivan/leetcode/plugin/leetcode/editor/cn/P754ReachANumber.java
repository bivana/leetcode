package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 754. 到达终点数字
// 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
// 你可以做一些数量的移动 numMoves : 
//
// 
// 每次你可以选择向左或向右移动。 
// 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。 
// 
//
// 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 示例 2: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 
//
// 提示: 
//
// 
// -10⁹ <= target <= 10⁹ 
// target != 0 
// 
//
// Related Topics 数学 二分查找 👍 248 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P754ReachANumber{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(3,solution.reachNumber(2));
        Assert.assertEquals(2,solution.reachNumber(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        public int reachNumber(int target) {
            if(target==0){
                return 0;
            }
            int ans=0;
            int move=0;
            int[] directs=new int[]{1,-1};
            Queue<Integer> queue=new ArrayDeque<>();
            queue.offer(0);
            while (!queue.isEmpty()){
                int len=queue.size();
                move++;
                l:for(int i=0;i<len;i++){
                    Integer v=queue.poll();
                    for(int direct:directs){
                        int val=v+direct*move;
                        if(val==target){
                            return move;
                        }else{
                            queue.offer(val);
                        }
                    }

                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
