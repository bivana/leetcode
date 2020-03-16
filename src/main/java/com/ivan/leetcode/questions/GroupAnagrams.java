package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 通过次数56,525提交次数92,4
 * */
public class GroupAnagrams {

    @Test
    public void test(){
        List<List<String>> list=groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        ShowUtil.showStringListMatrix(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            String key=generateKey(count);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> l=new ArrayList<>();
                l.add(s);
                map.put(key,l);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String generateKey(int[] array){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            sb.append(array[i]).append("#");
        }
        return sb.toString();
    }
}
