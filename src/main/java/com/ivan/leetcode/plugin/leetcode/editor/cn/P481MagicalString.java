package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 481. 神奇字符串
// 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 99 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P481MagicalString{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(3,solution.magicalString(6));
        Assert.assertEquals(1,solution.magicalString(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            if(n<=3){
                return 1;
            }
            int ans=1;
            StringBuilder sb=new StringBuilder("122");
            int index=2;
            char c='1';
            while (sb.length()<n){
                int i=Integer.valueOf(sb.substring(index,index+1));
                while (i>0&&sb.length()<n){
                    if(c=='1'){
                        ans++;
                    }
                    sb.append(c);
                    i--;
                }
                c=c=='1'?'2':'1';
                index++;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
