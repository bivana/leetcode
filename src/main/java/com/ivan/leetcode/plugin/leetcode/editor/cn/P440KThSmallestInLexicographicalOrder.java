package com.ivan.leetcode.plugin.leetcode.editor.cn;
//440 字典序的第K小数字
//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 315 👎 0

import java.util.List;

public class P440KThSmallestInLexicographicalOrder{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        TireTree tireTree=new TireTree(0);
        int sufix=1;
        for(int i=1;i<=n;i++){
            if(i%sufix==0){
                sufix=i;
            }
            tireTree.addRemain(i,sufix/10);
        }
        return 0;
    }

    class TireTree{
        int val;
        TireTree[] tireTrees=new TireTree[10];

        Integer total;

        public TireTree(int val){
            this.val=val;
        }

        public void addRemain(int val,int sufix){
            if(sufix<1){
                return;
            }
            int index=val/sufix;
            if(tireTrees[index]==null){
                tireTrees[index]=new TireTree(index);
                tireTrees[index].addRemain(val%sufix,sufix/10);
            }
        }

        public int getTotal(){
            if(total==null){
                total=0;
                for(TireTree tireTree:tireTrees){
                    if(tireTree!=null){
                        total+=tireTree.getTotal();
                    }
                }
            }
            return total;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}