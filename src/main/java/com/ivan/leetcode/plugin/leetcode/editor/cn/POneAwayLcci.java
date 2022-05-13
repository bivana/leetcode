package com.ivan.leetcode.plugin.leetcode.editor.cn;
//面试题 01.05 一次编辑
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 159 👎 0

public class POneAwayLcci{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // add edit delete
    // 字符串逐个比较
    // 不一样，add,delete,edit，继续判断
    public boolean oneEditAway(String first, String second) {
        boolean ans=false;
        int i=0;
        int j=0;
        while (j<second.length()&&i<first.length()){
            if(first.charAt(i)!=second.charAt(j)){
                break;
            }
            i++;
            j++;
        }
        //加
        if(isRemainEquals(first,i,second,j+1)){
            return true;
        }
        //减
        if(isRemainEquals(first,i+1,second,j)){
            return true;
        }
        //编辑
        if(isRemainEquals(first,i+1,second,j+1)){
            return true;
        }
        return ans;
    }

    public boolean isRemainEquals(String first,int firstIndex,String second,int secondIndex){
        if((first.length()-firstIndex)!=(second.length()-secondIndex)){
            return false;
        }
        while (firstIndex<first.length()){
            if(first.charAt(firstIndex++)!=second.charAt(secondIndex++)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}