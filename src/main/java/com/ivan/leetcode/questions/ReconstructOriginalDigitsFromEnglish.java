package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 423. 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 * 通过次数14,393提交次数24,105
 * */
public class ReconstructOriginalDigitsFromEnglish {

    @Test
    public void test(){
//        Assert.assertEquals("012",originalDigits("owoztneoer"));
//        Assert.assertEquals("45",originalDigits("fviefuro"));
        Assert.assertEquals("0123456789",originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }

    public String originalDigits(String s) {
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }

//    public String originalDigits(String s) {
//        Map<Character,Integer>[] nums=new HashMap[10];
//        nums[0]=new HashMap(){
//            {
//                put('z',1);
//                put('e',1);
//                put('r',1);
//                put('o',1);
//            }
//        };
//        nums[1]=new HashMap(){
//            {
//                put('o',1);
//                put('n',1);
//                put('e',1);
//            }
//        };
//        nums[2]=new HashMap(){
//            {
//                put('t',1);
//                put('w',1);
//                put('o',1);
//            }
//        };
//        nums[3]=new HashMap(){
//            {
//                put('t',1);
//                put('h',1);
//                put('r',1);
//                put('e',2);
//            }
//        };
//        nums[4]=new HashMap(){
//            {
//                put('f',1);
//                put('o',1);
//                put('u',1);
//                put('r',1);
//            }
//        };
//        nums[5]=new HashMap(){
//            {
//                put('f',1);
//                put('i',1);
//                put('v',1);
//                put('e',1);
//            }
//        };
//        nums[6]=new HashMap(){
//            {
//                put('s',1);
//                put('i',1);
//                put('x',1);
//            }
//        };
//        nums[7]=new HashMap(){
//            {
//                put('s',1);
//                put('e',2);
//                put('v',1);
//                put('n',1);
//            }
//        };
//        nums[8]=new HashMap(){
//            {
//                put('e',1);
//                put('i',1);
//                put('g',1);
//                put('h',1);
//                put('t',1);
//            }
//        };
//        nums[9]=new HashMap(){
//            {
//                put('n',2);
//                put('i',1);
//                put('e',1);
//            }
//        };
//        Map<Character,Integer> map=new HashMap<>();
//        for(Character c:s.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        StringBuilder sb=new StringBuilder();
//        Stack<Integer> stack=new Stack<>();
//        stack.push(0);
//        while (!map.isEmpty()){
//            int i=stack.peek();
//            if(i>=nums.length){//超出了边界，证明这条路走不通,回溯
//                stack.pop();
//                i=stack.pop();//取出上一个
//                //删除添加的
//                sb.deleteCharAt(sb.length()-1);
//                //添加回删掉的
//                for(Character key:nums[i].keySet()){
//                    map.put(key,map.getOrDefault(key,0)+nums[i].get(key));
//                }
//                stack.push(++i);
//                continue;
//            }
//            boolean contains=true;
//            for(Character key:nums[i].keySet()){
//                if(map.getOrDefault(key,0)<nums[i].get(key)){
//                    contains=false;
//                    break;
//                }
//            }
//            if(contains){
//                sb.append(i);
//                // 删除
//                for(Character key:nums[i].keySet()){
//                    map.put(key,map.get(key)-nums[i].get(key));
//                    if(map.get(key)==0){
//                        map.remove(key);
//                    }
//                }
//                stack.push(i);
//            }else{
//                stack.pop();//弹出
//                stack.push(++i);//放入
//            }
//        }
//        return sb.toString();
//    }


}
