package com.ivan.leetcode.plugin.leetcode.editor.cn;
//522 最长特殊序列 II
//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 121 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class P522LongestUncommonSubsequenceIi{

    public Solution solution=new Solution();

    @Test
    public void test(){
//        Assert.assertEquals(3,solution.findLUSlength(new String[]{"aba","cdc","eae"}));
        Assert.assertEquals(-1,solution.findLUSlength(new String[]{"aaa","aaa","aa"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String[] strs) {
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Double.valueOf(o1.length()).compareTo(Double.valueOf(o2.length()));
//            }
//        });
        for(int i=0;i<strs.length;i++){
            int tmp=0;
            for(int j=0;j<strs.length;j++){
                if(strs[i].length()<strs[j].length()||i==j){
                    continue;
                }
                if(isSub(strs[i],strs[j])){
                    tmp++;
                }
                if(tmp>0){
                    break;
                }
            }
            if(tmp==0){
                return strs[i].length();
            }
        }
        return -1;
    }

    public boolean isSub(String str,String target){
        int i=0;
        int j=0;
        while (i<target.length()){
            while (j<str.length()&&str.charAt(j)!=target.charAt(i)){
                j++;
            }
            if(j==str.length()){
                return false;
            }
            if(i==target.length()-1){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}