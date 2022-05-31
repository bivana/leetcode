package com.ivan.leetcode.plugin.leetcode.editor.cn;
//剑指 Offer II 114 外星文字典
//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 49 👎 0

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class POfferII114Jf1JuT{

    public Solution solution=new Solution();

    @Test
    public void test(){
        Assert.assertEquals("z",solution.alienOrder(new String[]{"z","z"}));

        Assert.assertEquals("wertf",solution.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        Map<Character,List<Character>> edges=new HashMap<>();//关系
        Map<Character,Integer> con=new HashMap<>();
        boolean valid=true;
        public String alienOrder(String[] words) {
            buildEdges(words);
            if(!valid){
                return "";
            }
            StringBuffer sb=new StringBuffer();
            Queue<Character> queue=new ArrayDeque<>();
            for(Character key:edges.keySet()){
                if(!con.containsKey(key)){
                    queue.offer(key);
                }
            }
            while (!queue.isEmpty()){
                Character c=queue.poll();
                sb.append(c);
                List<Character> afterList=edges.get(c);
                for(Character subC:afterList){
                    con.put(subC,con.get(subC)-1);
                    if(con.get(subC)==0){
                        queue.offer(subC);
                    }
                }
            }

            return sb.length()==edges.size()?sb.toString():"";
        }

        private void buildEdges(String[] words) {
            for(String word:words){
                for(int i=0;i<word.length();i++){
                    edges.put(word.charAt(i),new ArrayList<>());
                }
            }
            for(int i=1;i<words.length;i++){
                addEdges(words[i-1],words[i]);
            }
        }

        private void addEdges(String before,String after){
            int length=Math.min(before.length(),after.length());
            int i=0;
            while (i<length&&before.charAt(i)==after.charAt(i)){
                i++;
            }
            if(i<length){
                edges.get(before.charAt(i)).add(after.charAt(i));
                con.put(after.charAt(i),con.getOrDefault(after.charAt(i),0)+1);
            }
            if(i==length&&before.length()>after.length()){
                valid=false;
            }
        }


}


//leetcode submit region end(Prohibit modification and deletion)

}