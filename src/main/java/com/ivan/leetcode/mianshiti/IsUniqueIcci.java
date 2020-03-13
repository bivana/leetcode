package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * */
public class IsUniqueIcci {

    @Test
    public void test(){
        Assert.assertEquals(false,isUnique("leetcode"));
        Assert.assertEquals(true,isUnique("abc"));
    }

    public boolean isUnique(String astr) {
        if(astr==null||astr.length()==0){
            return true;
        }
        Set<Character> sets=new HashSet<>();
        for(char c:astr.toCharArray()){
            if(sets.contains(c)){
                return false;
            }
            sets.add(c);
        }
        return true;
    }
}
