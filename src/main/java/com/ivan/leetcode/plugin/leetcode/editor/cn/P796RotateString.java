package com.ivan.leetcode.plugin.leetcode.editor.cn;
//796 旋转字符串
//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。 
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 200 👎 0

public class P796RotateString{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        for(int k=0;k<s.length();k++){
            int i=k;
            int j=0;
            while (s.charAt(i)==goal.charAt(j)){
                i++;
                j++;
                if(i==s.length()){
                    i=0;
                }
                if(j==goal.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}