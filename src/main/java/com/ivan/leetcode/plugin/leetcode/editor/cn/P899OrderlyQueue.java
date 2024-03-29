package com.ivan.leetcode.plugin.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 *
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *
 *
 * 提示：
 *
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 * */
public class P899OrderlyQueue {

    @Test
    public void test(){
        Assert.assertEquals("acb",orderlyQueue("cba",1));
        Assert.assertEquals("aaabc",orderlyQueue("baaca",3));
    }

    //本质上，k排序后的结果就是可以取第k小个
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String min=s;
            StringBuilder sb=new StringBuilder(s);
            for(int i=1;i<s.length();i++){
                char c=sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if(sb.toString().compareTo(min)<0){
                    min=sb.toString();
                }
            }
            return min;
        }else{
            char[] array=s.toCharArray();
            Arrays.sort(array);
            return new String(array);
        }
    }
}
