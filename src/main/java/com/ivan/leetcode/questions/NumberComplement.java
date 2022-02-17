package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 * 提示：
 *
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * */
public class NumberComplement {

    @Test
    public void test(){
        Assert.assertEquals(2,findComplement(5));
        Assert.assertEquals(0,findComplement(1));
    }

    public int findComplement(int num) {
        int pos=-1;
        for(int i=31;i>=0;i--){
            if(((num>>i)&1)!=0){
                pos=i;
                break;
            }
        }
        int ans=0;
        for(int i=0;i<pos;i++){
            if (((num >> i) & 1) == 0) {
                ans |= (1 << i);
            }

        }
        return ans;
    }

    @Test
    public void test2(){
        System.out.println(5^7);
    }
}