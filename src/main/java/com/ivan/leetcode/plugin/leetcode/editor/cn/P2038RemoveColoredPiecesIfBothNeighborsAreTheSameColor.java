package com.ivan.leetcode.plugin.leetcode.editor.cn;
//2038 如果相邻两个颜色均相同则删除当前颜色
//总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第
// i 个颜色片段的颜色。 
//
// Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。 
//
// 
// 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。 
//
// 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。 
// Alice 和 Bob 不能 从字符串两端删除颜色片段。 
// 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。 
// 
//
// 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：colors = "AAABABB"
//输出：true
//解释：
//AAABABB -> AABABB
//Alice 先操作。
//她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。
//
//现在轮到 Bob 操作。
//Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
//因此，Alice 获胜，返回 true 。
// 
//
// 示例 2： 
//
// 输入：colors = "AA"
//输出：false
//解释：
//Alice 先操作。
//只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
//因此，Bob 获胜，返回 false 。
// 
//
// 示例 3： 
//
// 输入：colors = "ABBBBBBBAAA"
//输出：false
//解释：
//ABBBBBBBAAA -> ABBBBBBBAA
//Alice 先操作。
//她唯一的选择是删除从右数起第二个 'A' 。
//
//ABBBBBBBAA -> ABBBBBBAA
//接下来轮到 Bob 操作。
//他有许多选择，他可以选择任何一个 'B' 删除。
//
//然后轮到 Alice 操作，她无法删除任何片段。
//所以 Bob 获胜，返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colors.length <= 10⁵ 
// colors 只包含字母 'A' 和 'B' 
// 
// Related Topics 贪心 数学 字符串 博弈 👍 19 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2038RemoveColoredPiecesIfBothNeighborsAreTheSameColor{

    @Test
    public void test(){
        int a=Integer.parseInt("1000",2);
        int b=Integer.parseInt("11011",2);
        System.out.println(Integer.toBinaryString(a&b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        Map<String,Boolean>[] canWinMapArray=new Map[]{new HashMap(),new HashMap()};
        Map<String,List<Integer>>[] canRemoveMapArray=new Map[]{new HashMap(),new HashMap()};
        int round=1;

    public boolean winnerOfGame(String colors) {
        int r=round%2;
        if(canWinMapArray[r].get(colors)==null){
            List<Integer> list=canRemove(colors,r);
            if(list==null||list.size()==0){
                canWinMapArray[r].put(colors,false);
            }else{
                StringBuilder sb=new StringBuilder(colors);
                for(int i:list){
                    Character c=colors.charAt(i);
                    String newString=sb.deleteCharAt(i).toString();
                    round++;
                    canWinMapArray[r].put(colors,winnerOfGame(newString));
                    sb.insert(i,c);
                    round--;
                }
            }


        }
        return canWinMapArray[r].get(colors);
    }


    public List<Integer> canRemove(String colors,int r){
        if(canRemoveMapArray[r].get(colors)==null){
            Character c='A';
            if(r==0){
                c='B';
            }
            List<Integer> list=new ArrayList<>();
            int count=0;
            for(int i=0;i<colors.length();i++){
                if(colors.charAt(i)==c){
                    count++;
                }else{
                    count=0;
                }
                if(count>=3){
                    list.add(i);
                }
            }
            canRemoveMapArray[r].put(colors,list);
        }
        return canRemoveMapArray[r].get(colors);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}