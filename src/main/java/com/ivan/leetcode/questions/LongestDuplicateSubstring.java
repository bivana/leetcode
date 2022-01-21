package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1044. 最长重复子串
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 *
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "banana"
 * 输出："ana"
 * 示例 2：
 *
 * 输入：s = "abcd"
 * 输出：""
 *
 *
 * 提示：
 *
 * 2 <= s.length <= 3 * 104
 * s 由小写英文字母组成
 * */
public class LongestDuplicateSubstring {

    @Test
    public void test(){
        Assert.assertEquals("ana",longestDupSubstring("banana"));
        Assert.assertEquals("",longestDupSubstring("abcd"));
//        "nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"
    }

    public String longestDupSubstring(String s) {
        Random random = new Random();
        // 生成两个进制
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        // 生成两个模 ，模一般选取编码的信息量的平方的数量级
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int n = s.length();
        // 先对所有字符进行编码
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = s.charAt(i) - 'a';
        }
        // 二分查找的范围是[1, n-1]
        int l = 1, r = n - 1;
        int length = 0, start = -1;
        while (l <= r) {
            //二分，中间
            int m = l + (r - l + 1) / 2;
            int idx = check(arr, m, a1, a2, mod1, mod2);
            if (idx != -1) {
                // 有重复子串，移动左边界
                l = m + 1;
                length = m;
                start = idx;
            } else {
                // 无重复子串，移动右边界
                r = m - 1;
            }
        }
        return start != -1 ? s.substring(start, start + length) : "";
    }

    //arr 解码后的数字
    //m 尝试的中间长度
    //a1  n进制1
    //a2 n进制2
    //mod1  取模1
    //mod2  取模2
    public int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1);//进制1的m次方值，防止溢出
        long aL2 = pow(a2, m, mod2);//进制2的m次方值，防止溢出
        long h1 = 0, h2 = 0;
        //进行计算
        for (int i = 0; i < m; ++i) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;//h1=(h1*a1+arr[i])
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        //h0=0×26^2+1×26^1+2×26^0=28
        // 存储一个编码组合是否出现过
        Set<Long> seen = new HashSet<Long>();
        seen.add(h1 * mod2 + h2);
        //n字符串的长度 m 子串的长度
        for (int start = 1; start <= n - m; ++start) {//子串从1到最后的start位置

            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }

            long num = h1 * mod2 + h2;
            // 如果重复，则返回重复串的起点
            if (!seen.add(num)) {
                return start;
            }
        }
        // 没有重复，则返回-1
        return -1;
    }

    //求a的m次，超出的进行mod求余
    //a 进制，基准质数
    //m 被匹配字符串的长度
    //取模的数
    public long pow(int a, int m, int mod) {
        long ans = 1;
        long contribute = a;
        while (m > 0) {
            if (m % 2 == 1) {//如果是奇数
                ans = ans * contribute % mod;//pow，并取余，防止超出
                if (ans < 0) {
                    ans += mod;
                }
            }
            //前面奇数已经处理了，后面的只会是偶数，求pow相乘
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            m /= 2;
        }
        return ans;
    }




}
