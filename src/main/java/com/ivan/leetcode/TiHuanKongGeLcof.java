package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * */
public class TiHuanKongGeLcof {

    @Test
    public void test(){
        Assert.assertEquals("We%20are%20happy.",replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}
