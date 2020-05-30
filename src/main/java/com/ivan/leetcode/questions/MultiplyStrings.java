package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * */
public class MultiplyStrings {

    @Test
    public void test(){
        Assert.assertEquals("121932631112635269",multiply("123456789","987654321"));

        Assert.assertEquals("6",multiply("2","3"));
        Assert.assertEquals("56088",multiply("123","456"));
        Assert.assertEquals("0",multiply("9133","0"));
    }

    class MultiResult{
        public int val;
        public int carry;

        public MultiResult(int i){
            String s=i+"";
            val=s.charAt(s.length()-1)-'0';
            if(s.length()>1){
                carry=s.charAt(0)-'0';
            }
        }
    }

    public String multiply(String num1, String num2) {
        if(num1.startsWith("0")||num2.startsWith("0")){
            return "0";
        }
        String[] addRs=new String[num2.length()];
        String ext="";
        for(int i=num2.length()-1;i>=0;i--){
            addRs[i]=singleMulti(num1,num2.charAt(i))+ext;
            ext=ext+"0";
        }
        String sum=addRs[0];
        for(int i=1;i<addRs.length;i++){
            sum=add(sum,addRs[i]);
        }
        return sum;
    }

    public String add(String num1,String num2){
        if(num1==null||num1.length()==0){
            return num2;
        }
        if(num2==null || num2.length()==0){
            return num1;
        }

        int ext=0;
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=num1;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num1.length();i++){
            int a=num1.charAt(num1.length()-1-i)-'0';
            int b=0;
            if(i<num2.length()){
                b=num2.charAt(num2.length()-1-i)-'0';
            }
            int add=a+b+ext;
            if(add>=10){
                sb.append(new Integer(add).toString().substring(1));
                ext=1;
            }else{
                sb.append(add);
                ext=0;
            }
        }
        if(ext!=0){
            sb.append(ext);
        }
        return sb.reverse().toString();
    }

    public String singleMulti(String num1,char num2){
        int carry=0;
        MultiResult rs;
        StringBuilder sb=new StringBuilder();
        for(int i=num1.length()-1;i>=0;i--){
            rs=multiply(num1.charAt(i),num2);
            int val=rs.val+carry;
            if(val>=10){
                sb.append(new Integer(val).toString().substring(1));
                carry=rs.carry+1;
            }else{
                sb.append(val);
                carry=rs.carry;
            }

        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public MultiResult multiply(char a,char b){
        int i=a-'0';
        int j=b-'0';
        int multi=i*j;
        return new MultiResult(multi);
    }


    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arrayInt = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int z = length2 - 1; z >= 0; z--) {
                int number1 = num1.charAt(i) - 48;
                int number2 = num2.charAt(z) - 48;
                arrayInt[i + z] += number1 * number2;
                if (arrayInt[i + z] >= 10 && (i + z) != 0) {
                    arrayInt[i + z - 1] += arrayInt[i + z] / 10;
                    arrayInt[i + z] = arrayInt[i + z] % 10;
                }
            }
        }

        for (int i = 0; i <= length1 + length2 - 2; i++) {
            str.append(arrayInt[i]);
        }

        return str.toString();
    }
}
