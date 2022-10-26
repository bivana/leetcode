package com.ivan.leetcode.plugin.leetcode.editor.cn;//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 358 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P856ScoreOfParentheses{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(1,solution.scoreOfParentheses("()"));
        Assert.assertEquals(2,solution.scoreOfParentheses("(())"));
        Assert.assertEquals(2,solution.scoreOfParentheses("()()"));
        Assert.assertEquals(6,solution.scoreOfParentheses("(()(()))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            int cnt=0;
            Deque<Integer> stack=new ArrayDeque<Integer>();
            for(char c:s.toCharArray()){
                if(c=='('){
                    cnt++;
                    if(stack.size()<cnt){
                        stack.push(0);
                    }
                }else if(c==')'){
                    cnt--;
                    int val=stack.pop();
                    if(cnt==stack.size()){
                        stack.push(++val);
                    }else{
                        stack.push(stack.pop()+2*val);
                    }
                }
            }
            return stack.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
