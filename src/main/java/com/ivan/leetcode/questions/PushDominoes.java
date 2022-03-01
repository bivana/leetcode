package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 838. 推多米诺
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 示例 2：
 *
 *
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 *
 * 提示：
 *
 * n == dominoes.length
 * 1 <= n <= 105
 * dominoes[i] 为 'L'、'R' 或 '.'
 * 通过次数12,053提交次数22,349
 * */
public class PushDominoes {

    @Test
    public void test(){
        Assert.assertEquals("RR.L",pushDominoes("RR.L"));
        Assert.assertEquals("LL.RR.LLRRLL..",pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        Queue<Integer> queue=new ArrayDeque<>();
        char[] characters=dominoes.toCharArray();
        for(int i=0;i<dominoes.length();i++){
            if(characters[i]=='L'||characters[i]=='R'){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int size=queue.size();
            Map<Integer,Character> map=new HashMap<>();
            for(int i=0;i<size;i++){
                int index=queue.poll();
                if(characters[index]=='L'){
                    if(index-1>=0&&characters[index-1]=='.'){
                        if(map.containsKey(index-1)){
                            map.remove(index-1);
                        }else{
                            map.put(index-1,'L');
                        }
                    }
                }else if(characters[index]=='R'){
                    if(index+1<characters.length&&characters[index+1]=='.'){
                        if(map.containsKey(index+1)){
                            map.remove(index+1);
                        }else{
                            map.put(index+1,'R');
                        }
                    }
                }
            }
            for(Map.Entry<Integer,Character> entry:map.entrySet()){
                characters[entry.getKey()]=entry.getValue();
                queue.add(entry.getKey());
            }
        }
        return new String(characters);
    }
}
