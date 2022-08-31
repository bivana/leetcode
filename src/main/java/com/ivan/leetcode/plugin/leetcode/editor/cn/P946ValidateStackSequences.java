package com.ivan.leetcode.plugin.leetcode.editor.cn;


//946. 验证栈序列
// 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// pushed 的所有元素 互不相同 
// popped.length == pushed.length 
// popped 是 pushed 的一个排列 
// 
//
// Related Topics 栈 数组 模拟 👍 300 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P946ValidateStackSequences{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals(true,solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        Assert.assertEquals(false,solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        Assert.assertEquals(true,solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack=new Stack<>();
            int k=0;
            int i=0;
            while (i<popped.length){
                if(!stack.isEmpty()&&stack.peek().equals(popped[i])){
                    stack.pop();
                    i++;
                }else{
                    while (k<pushed.length&&pushed[k]!=popped[i]){
                        stack.push(pushed[k]);
                        k++;
                    }
                    k++;
                    i++;
                }
            }
            if(i==k){
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
