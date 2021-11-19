package com.ivan.leetcode.questions;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Zcorvert {
    public static void main(String[] args){
        Zcorvert zcorvert=new Zcorvert();
//        Assert.assertEquals("LCIRETOESIIGEDHN",zcorvert.convert("LEETCODEISHIRING",3));
//        Assert.assertEquals("LDREOEIIECIHNTSG",zcorvert.convert("LEETCODEISHIRING",4));
        System.out.println(zcorvert.convert("A",2));
    }
    static {
        System.out.println("ccccc");
    }
    public String convert(String s, int numRows){
        if (numRows == 1) return s;

        String[] rows=new String[Math.min(s.length(),numRows)]; // 防止s的长度小于行数
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            if(rows[curRow]==null){
                rows[curRow]="";
            }
            rows[curRow] += c;
            if (curRow == 0 || curRow == numRows - 1) {// 当前行curRow为0或numRows -1时，箭头发生反向转折
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        String ret="";
        for (String row : rows) {// 从上到下遍历行
            ret += row==null?"":row;
        }

        return ret;

    }
//
//    public String convert(String s, int numRows) {
////        char[][] z=new char[s.length()*(numRows-1)/(numRows*2-2)][numRows];
//        char[][] z=new char[s.length()/2][numRows];//二维数组，由上面公式推导列数就是总长度除以2
//        int part=numRows*2-2;//半个z的长度
//        for(int i=0;i<s.length();i++){
//            int c=(i/part)*(numRows-1);
//            int remain=i%(part+1);
//            if(remain>numRows){
//                c=c+remain-numRows;
//            }
//            int r=0;
//            z[c][2]=s.charAt(i);
//
//        }
//        return null;
//    }
}
