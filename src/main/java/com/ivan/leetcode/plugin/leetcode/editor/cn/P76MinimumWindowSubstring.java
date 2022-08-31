package com.ivan.leetcode.plugin.leetcode.editor.cn;//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2099 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class P76MinimumWindowSubstring{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals("BANC",solution.minWindow("ADOBECODEBANC","ABC"));
        Assert.assertEquals("b",solution.minWindow("ab","b"));
        Assert.assertEquals("a",solution.minWindow("a","a"));
        Assert.assertEquals("",solution.minWindow("a","aa"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //滑动窗口，不包含，右移，包含，左移
        public String minWindow(String s, String t) {
            Map<Character,Integer> targetMap=new HashMap<>();
            for(int i=0;i<t.length();i++){
                targetMap.put(t.charAt(i),targetMap.getOrDefault(t.charAt(i),0)+1);
            }
            String ans="";
            int l=0;
            int r=0;
            Map<Character,Integer> map=new HashMap<>();
            map.put(s.charAt(l),1);
            while (r<s.length()&&l<=r){
                if(check(map,targetMap)){
                    if("".equals(ans)||(r-l+1)<ans.length()){
                        ans=s.substring(l,r+1);
                    }
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    l++;
                }else{
                    //不满足，r右移
                    r++;
                    if(r<s.length()){
                        map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
                    }
                }
            }
            return ans;
        }

        public boolean check(Map<Character,Integer> map,Map<Character,Integer> target){
            for(Character key:target.keySet()){
                if(target.getOrDefault(key,0)>map.getOrDefault(key,0)){
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
