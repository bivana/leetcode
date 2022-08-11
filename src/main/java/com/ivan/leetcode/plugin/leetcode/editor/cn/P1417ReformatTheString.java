package com.ivan.leetcode.plugin.leetcode.editor.cn;//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
// 1417. 重新格式化字符串
// 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。 
//
// 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "a0b1c2"
//输出："0a1b2c"
//解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
// 
//
// 示例 2： 
//
// 输入：s = "leetcode"
//输出：""
//解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
// 
//
// 示例 3： 
//
// 输入：s = "1229857369"
//输出：""
//解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
// 
//
// 示例 4： 
//
// 输入：s = "covid2019"
//输出："c2o0v1i9d"
// 
//
// 示例 5： 
//
// 输入：s = "ab123"
//输出："1a2b3"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母和/或数字组成。 
// 
//
// Related Topics 字符串 👍 48 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P1417ReformatTheString{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals("0a1b2c",solution.reformat("a0b1c2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            int n=0;
            int c=0;
            char[] charArray=s.toCharArray();
            for(char ch:charArray){
                if(ch>='0' && ch<='9'){
                    n++;
                }else if(ch>='a'&&ch<='z'){
                    c++;
                }
            }
            if(Math.abs(n-c)>1){
                return "";
            }
            if(c>=n){
                //偶数放c,基数放n
                int i=0;
                int j=1;
                while (i<charArray.length&&j<charArray.length){
                    while (i<charArray.length&&charArray[i]>='a'&&charArray[i]<='z'){
                        i=i+2;
                    }
                    while (j<charArray.length&&charArray[j]>='0'&&charArray[j]<='9'){
                        j=j+2;
                    }
                    if(i<charArray.length&&j<charArray.length){
                        char tmp=charArray[i];
                        charArray[i]=charArray[j];
                        charArray[j]=tmp;
                    }
                }
            }else{
                //偶数放c,基数放n
                int i=0;
                int j=1;
                while (i<charArray.length&&j<charArray.length){
                    while (i<charArray.length&&charArray[i]>='0'&&charArray[i]<='9'){
                        i=i+2;
                    }
                    while (j<charArray.length&&charArray[j]>='a'&&charArray[j]<='z'){
                        j=j+2;
                    }
                    if(i<charArray.length&&j<charArray.length){
                        char tmp=charArray[i];
                        charArray[i]=charArray[j];
                        charArray[j]=tmp;
                    }
                }
            }
            return new String(charArray);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}

