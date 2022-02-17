package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 *
 * 提示：
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * */
public class LongestHappyString {

    @Test
    public void test(){
        Assert.assertEquals("ccaccbcc",longestDiverseString(1,1,7));
        Assert.assertEquals("aabbc",longestDiverseString(2,2,1));
        Assert.assertEquals("aabaa",longestDiverseString(7,1,0));
    }

    //贪心
    public String longestDiverseString(int a, int b, int c) {
        boolean flag=true;
        StringBuilder sb=new StringBuilder();
        PriorityQueue<int[]> queue=new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
        if(a>0){
            queue.add(new int[]{'a',a});
        }
        if(b>0){
            queue.add(new int[]{'b',b});
        }
        if(c>0){
            queue.add(new int[]{'c',c});
        }
        int[] pre=null;
        Character last=null;
        while (queue.size()>0){
            int[] first=queue.poll();
            char charcter=(char)first[0];
            if(last!=null&&charcter==last){
                if(queue.size()==0){
                    break;
                }
                int[] second=queue.poll();
                sb.append((char)second[0]);
                second[1]--;
                last=(char)second[0];
                if(second[1]>0){
                    queue.add(second);
                }
            }else{
                sb.append(charcter);
                first[1]--;
                last=charcter;
                if(first[1]>0){
                    sb.append(charcter);
                    first[1]--;
                }
            }
            if(first[1]>0){
                queue.add(first);
            }
        }
        return sb.toString();
    }

}
