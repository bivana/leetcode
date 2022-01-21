package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * */
public class RepeatedStringMatch {

    @Test
    public void test(){
//        Assert.assertEquals(3,repeatedStringMatch("abcd","cdabcdab"));
        Assert.assertEquals(2,repeatedStringMatch("a","aa"));
        Assert.assertEquals(1,repeatedStringMatch("a","a"));
        Assert.assertEquals(-1,repeatedStringMatch("abc","wxyz"));

    }

    public int repeatedStringMatch(String a, String b) {
        int lastA=a.length()-1;
        for(int s=0;s<a.length();s++){//a的起步尝试
            int i=s;
            int j=0;
            int repeat=1;//重复次数
            while (j<b.length()){
                if(a.charAt(i)==b.charAt(j)){//相等，继续
                    if(i==0&&j!=0){
                        repeat++;//循环+1
                    }
                    if(i==lastA){
                        i=0;
                    }else{
                        i++;
                    }
                    j++;
                    continue;
                }else{//不等，跳出循环
                    repeat=-1;
                    break;
                }
            }
            if(repeat>0){
                return repeat;
            }
        }
        return -1;
    }

    /***/

    @Test
    public void testStringOf(){
        String a="asfdsf";
        a.indexOf("dc");


    }

    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param   source       the characters being searched.
     * @param   sourceOffset offset of the source string.
     * @param   sourceCount  count of the source string.
     * @param   target       the characters being searched for.
     * @param   targetOffset offset of the target string.
     * @param   targetCount  count of the target string.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {//如果其实索引比待搜索的长度长
            return (targetCount == 0 ? sourceCount : -1);//如果待匹配长度为0，那么返回sourceCount，不然返回-1 这里没明白用啥的
        }
        if (fromIndex < 0) {//如果起始位置<0，置为0
            fromIndex = 0;
        }
        if (targetCount == 0) {//如果待匹配长度为0，返回起始搜索位
            return fromIndex;
        }

        char first = target[targetOffset];//首个待匹配字符串的char
        int max = sourceOffset + (sourceCount - targetCount);//最大的可能索引下标

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {//找到第一个匹配字符串
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }


    @Test
    public void testKmpSearch(){
        Assert.assertEquals(2,kmpSearch("abcdbba","cd"));
        Assert.assertEquals(0,kmpSearch("aa","a"));
        Assert.assertEquals(-1,kmpSearch("abcdbba","be"));
    }

    public int kmpSearch(String str,String reg){
        //建立导航
        int[] navigator=buildNavigator(reg);

        for(int i=0,j=0;i<str.length();i++){
            //匹配不成功，向上找
            while (j>0&&str.charAt(i)!=reg.charAt(j)){
                j=navigator[j];
            }
            //匹配成功，字符串++
            if(str.charAt(i)==reg.charAt(j)){
                j++;
            }
            //整一段匹配成功，直接返回下标
            if(j==reg.length()){
                return i-reg.length()+1;
            }
        }
        return -1;

//        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
//        for (int i = 1, j = 0; i <= n; i++) {
//            // 匹配不成功 j = next(j)
//            while (j > 0 && s[i] != p[j + 1]) j = next[j];
//            // 匹配成功的话，先让 j++，结束本次循环后 i++
//            if (s[i] == p[j + 1]) j++;
//            // 整一段匹配成功，直接返回下标
//            if (j == m) return i - m;
//        }


    }

    /***/
    @Test
    public void testBuildNavigator(){
        Assert.assertArrayEquals(new int[]{0,1,2,0,0,1,0},buildNavigator("aaabbab"));
    }

    //构建快速导航
    private int[] buildNavigator(String reg){
        if(reg==null||reg.equals("")){
            return new int[0];
        }else if(reg.length()==1){
            return new int[]{0};
        }else{
            int[] navigator=new int[reg.length()];
            for(int i=0,j=1;j<reg.length();j++){
                //如果不等，i往前回溯找前一个点的值，不断循环,
                while (i>0&&reg.charAt(j)!=reg.charAt(i)){
                    i=navigator[i-1];
                }
                //如果相等，那么i，j往后移动
                if(reg.charAt(i)==reg.charAt(j)){
                    i++;
                }
                navigator[j]=i;
            }
            return navigator;
        }
    }
}
