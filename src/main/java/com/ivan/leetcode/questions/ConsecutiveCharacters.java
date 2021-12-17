package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 *
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 *
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 *
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 *
 * 输入：s = "tourist"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * 通过次数23,597提交次数38,820
 * */
public class ConsecutiveCharacters {

    @Test
    public void test(){
        Assert.assertEquals(2,maxPower("cc"));
        Assert.assertEquals(2,maxPower("leetcode"));
        Assert.assertEquals(5,maxPower("abbcccddddeeeeedcba"));
        Assert.assertEquals(5,maxPower("triplepillooooow"));
        Assert.assertEquals(11,maxPower("hooraaaaaaaaaaay"));
        Assert.assertEquals(1,maxPower("tourist"));
    }

    public int maxPower(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int ans=1;
        int tmp=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                tmp++;
            }else{
                ans=tmp>ans?tmp:ans;
                tmp=1;
            }
        }
        ans=tmp>ans?tmp:ans;
        return ans;
    }
}
