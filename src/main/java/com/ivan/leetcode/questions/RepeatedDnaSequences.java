package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * */
public class RepeatedDnaSequences {

    @Test
    public void test(){
        Assert.assertArrayEquals(new String[]{"AAAAAAAAAA"},findRepeatedDnaSequences("AAAAAAAAAAA").toArray());

        Assert.assertArrayEquals(new String[]{"AAAAACCCCC","CCCCCAAAAA"},findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray());
        Assert.assertArrayEquals(new String[]{"AAAAAAAAAA"},findRepeatedDnaSequences("AAAAAAAAAAAAA").toArray());

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rs=new ArrayList<>();
        int len=10;
        if(s!=null&&s.length()>len){
            Map<Character,Integer> transfer=new HashMap<Character,Integer>(){{
                put('A',0);
                put('C',1);
                put('G',2);
                put('T',3);
            }};
            Map<Integer,Integer> count=new HashMap<>();
            int x=0;
            int left=(1<<(len*2))-1;
            for(int i=0;i<len-1;i++){
                x=(x<<2) | transfer.get(s.charAt(i));
            }
            for(int i=0;i<=s.length()-len;i++){
                x=((x<<2) | transfer.get(s.charAt(i+len-1))) & left;
                count.put(x,count.getOrDefault(x,0)+1);
                if(count.get(x)==2){
                    rs.add(s.substring(i,i+len));
                }
            }

        }
        return rs;
    }


    public static void main(String[] args){
        System.out.println(0^0&1);
        System.out.println((0^0)&1);
        System.out.println(0^(0&1));

    }
}
