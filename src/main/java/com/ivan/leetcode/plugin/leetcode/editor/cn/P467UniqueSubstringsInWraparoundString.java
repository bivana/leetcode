package com.ivan.leetcode.plugin.leetcode.editor.cn;
//467 环绕字符串中唯一的子字符串
//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1: 
//
// 
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
// 
//
// 示例 2: 
//
// 
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 示例 3: 
//
// 
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母构成 
// 
// Related Topics 字符串 动态规划 👍 236 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class P467UniqueSubstringsInWraparoundString{

    public Solution solution=new Solution();

    @Test
    public void test(){
//        Assert.assertEquals(1,solution.findSubstringInWraproundString("a"));
//        Assert.assertEquals(2,solution.findSubstringInWraproundString("cac"));
        Assert.assertEquals(6,solution.findSubstringInWraproundString("zab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Set<String> set;
    public int findSubstringInWraproundString(String p) {
        set=new HashSet<>();
        int l=0;
        int r=1;
        while (l<p.length()){
            //连续的，一直往后加
            while (r<p.length()&&isContinueStr(p.charAt(r-1),p.charAt(r))){
                r++;
            }
            findSub(p,l,r);
            l=r;
            r=l+1;
        }
        return set.size();
    }

    public boolean isContinueStr(char a,char b){
        if(a=='z'){
            return b=='a';
        }else{
            return a+1==b;
        }
    }

    public void findSub(String p,int l,int r){
        for(int i=l;i<r;i++){
            for(int j=i+1;j<=r;j++){
                set.add(p.substring(i,j));
            }
        }
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}