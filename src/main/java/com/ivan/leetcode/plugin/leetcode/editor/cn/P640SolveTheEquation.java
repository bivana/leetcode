package com.ivan.leetcode.plugin.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *
 *
 * 提示:
 *
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 * ​​​
 * 通过次数17,767提交次数40,004
 * */
public class P640SolveTheEquation {

    @Test
    public void test(){
        Assert.assertEquals("No solution",solveEquation("x=x+2"));
        Assert.assertEquals("Infinite solutions",solveEquation("x=x"));
        Assert.assertEquals("x=2",solveEquation("x+5-3+x=6+x-2"));
        Assert.assertEquals("x=-1",solveEquation("2x+3x-6x=x+2"));
        Assert.assertEquals("x=2",solveEquation("x+5-3+x=6+x-2"));
        Assert.assertEquals("x=0",solveEquation("2x=x"));
    }

    public String solveEquation(String equation) {
        int x=0;
        int o=0;
        int direct=1;
        int xDirect=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<equation.length();i++){
            char c=equation.charAt(i);
            if(c<'0'||c>'9'){
                if(c=='x'){
                    int num=1;
                    if(sb.length()>0){
                        num=Integer.valueOf(sb.toString());
                    }
                    x+=num*direct*xDirect;
                }else{

                    if(sb.length()>0){
                        o-=Integer.valueOf(sb.toString())*direct*xDirect;
                    }
                    if(c=='+'){
                        direct=1;
                    }else if(c=='-'){
                        direct=-1;
                    }else if(c=='='){
                        direct=1;
                        xDirect=-1;
                    }
                }
                sb=new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        if(sb.length()>0){
            o-=Integer.valueOf(sb.toString())*direct*xDirect;
        }
        if(x==0&&o==0){
            return "Infinite solutions";
        }
        if(x==0){
            return "No solution";
        }
        String ans="x="+(o/x);
        return ans;
    }




}
