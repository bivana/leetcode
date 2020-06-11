package com.ivan.leetcode.questions;

import junit.framework.Assert;

/**
 * 12. 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * */
public class IntToRoman {

    enum Roman{

        I(1)
        ,IV(4)
        ,V(5)
        ,IX(9)
        ,X(10)
        ,XL(40)
        ,L(50)
        ,XC(90)
        ,C(100)
        ,CD(400)
        ,D(500)
        ,CM(900)
        ,M(1000);

        private int value=0;

        private Roman(int value){
            this.value=value;
        }

    }

    public static void main(String[] args){
        IntToRoman intToRoman=new IntToRoman();
        Assert.assertEquals("III",intToRoman.intToRoman(3));
        Assert.assertEquals("IV",intToRoman.intToRoman(4));
        Assert.assertEquals("IX",intToRoman.intToRoman(9));
        Assert.assertEquals("LVIII",intToRoman.intToRoman(58));
        Assert.assertEquals("MCMXCIV",intToRoman.intToRoman(1994));
    }



    public String intToRoman(int num) {
        StringBuilder roman=new StringBuilder();
        int i=Roman.values().length-1;
        while (i>=0){
            Roman r=Roman.values()[i];
            while (num>=r.value){
                roman.append(r);
                num=num-r.value;
            }
            i--;
        }
        return roman.toString();
    }




//    public String intToRoman(int num) {
//        StringBuilder roman=new StringBuilder();
//        for(int i=Roman.values().length-1;i>=0;i--){
//            Roman r=Roman.values()[i];
//            if(r==Roman.D && num/100==9){//900 处理
//                roman.append(Roman.C).append(Roman.M);
//                num=num-900;
//            }else if(r==Roman.C && num/100==4){//400 处理
//                roman.append(Roman.C).append(Roman.D);
//                num=num-400;
//            }else if(r==Roman.L && num/10==9){//90 处理
//                roman.append(Roman.X).append(Roman.C);
//                num=num-90;
//            }else if(r==Roman.X && num/10==4){//40 处理
//                roman.append(Roman.X).append(Roman.L);
//                num=num-40;
//            }else if(r==Roman.V && num==9){//9 处理
//                roman.append(Roman.I).append(Roman.X);
//                num=num-9;
//            }else if(r==Roman.I && num==4){//4 处理
//                roman.append(Roman.I).append(Roman.V);
//                num=num-4;
//            }else{
//                int len=num/r.value;
//                if(len>0){
//                    for(int j=0;j<len;j++){
//                        roman.append(r.toString());
//                    }
//                    num=num%r.value;
//                }
//
//            }
//        }
//        return roman.toString();
//    }
}
