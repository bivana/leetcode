package com.ivan.leetcode.plugin.leetcode.editor.cn;

//
// 816. 模糊坐标
// 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 80 👎 0


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P816AmbiguousCoordinates{

    public Solution solution=new Solution();

    @Test
    public void test(){
        List<String> list2=solution.getPosibleNum("000");

        List<String> list=solution.ambiguousCoordinates("(0123)");
//        Assert.assertArrayEquals(new String[]{"(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"},solution.ambiguousCoordinates("(123)").toArray(new String[4]));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans=new ArrayList<>();
            s=s.substring(1,s.length()-1);
            int len=s.length();
            for(int i=1;i<len;i++){
                List<String> part1List=getPosibleNum(s.substring(0,i));
                if(part1List.size()==0){
                    continue;
                }
                List<String> part2List=getPosibleNum(s.substring(i,len));
                if(part2List.size()==0){
                    continue;
                }
                for(String part1:part1List){
                    for(String part2:part2List){
                        ans.add("("+part1+", "+part2+")");
                    }
                }
            }
            return ans;
        }

        public List<String> getPosibleNum(String s){
            List<String> ans=new ArrayList<>();
            if(s.charAt(0)!='0'||s.length()==1){
                ans.add(s);
            }
            for(int i=1;i<s.length();i++){
                if((i!=1&&s.charAt(0)=='0')||s.charAt(s.length()-1)=='0'){
                    continue;
                }
                ans.add(s.substring(0,i)+"."+s.substring(i));
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
