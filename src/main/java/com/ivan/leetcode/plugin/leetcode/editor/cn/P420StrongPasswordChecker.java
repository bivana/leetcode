package com.ivan.leetcode.plugin.leetcode.editor.cn;
//420 强密码检验器
//
//如果一个密码满足下述所有条件，则认为这个密码是强密码：
//
// 
// 由至少 6 个，至多 20 个字符组成。 
// 至少包含 一个小写 字母，一个大写 字母，和 一个数字 。 
// 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以算是强密码)。 
// 
//
// 给你一个字符串 password ，返回 将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 
//。 
//
// 在一步修改操作中，你可以： 
//
// 
// 插入一个字符到 password ， 
// 从 password 中删除一个字符，或 
// 用另一个字符来替换 password 中的某个字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：password = "a"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：password = "aA1"
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：password = "1337C0d3"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= password.length <= 50 
// password 由字母、数字、点 '.' 或者感叹号 '!' 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 108 👎 0

import org.junit.Assert;
import org.junit.Test;

public class P420StrongPasswordChecker{

    private Solution solution=new Solution();

    @Test
    public void test(){

        Assert.assertEquals(2,solution.strongPasswordChecker(new String("ABABABABABABABABABAB1")));


        Assert.assertEquals(3,solution.strongPasswordChecker(new String("1111111111")));


        Assert.assertEquals(2,solution.strongPasswordChecker(new String("aaa111")));

        Assert.assertEquals(0,solution.strongPasswordChecker(new String("aaAA11")));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int strongPasswordChecker(String password) {
        int ans=0;
        int addCnt=password.length()<6?6-password.length():0;
        int cutCnt=password.length()>20?20-password.length():0;


        int[] hasArray=new int[3];
        Character pre=null;
        int con=0;
        int ill=0;
        for(Character c:password.toCharArray()){
            if(c>='a' && c<='z'){
                hasArray[0]=1;
            }else if(c>='A' && c<='Z'){
                hasArray[1]=1;
            }else if( c>='0' && c<='9'){
                hasArray[2]=1;
            }
            if(c==pre){
                con++;
                if(con==3){
                    con=0;
                    ill++;
                }
            }else{
                con=1;
                pre=c;
            }

        }
        int hasCnt=hasArray[0]+hasArray[1]+hasArray[2];
        ans+=(3-hasCnt);

        int addOrCut=0;
        if(password.length()<6){
            addOrCut=6-password.length();
        }else if(password.length()>20){
            addOrCut=password.length()-20;
        }

        if(addCnt>0){
            ans+=Math.max(ans,addCnt);
        }
        if(cutCnt>0){
            ans+=cutCnt;
        }
        ans+=(ill-ans>0?ill-ans:0);

        return ans;
    }

//    public int strongPasswordChecker(String password) {
//        int ans=0;
//        int[] hasArray=new int[3];
//        Character pre=null;
//        int con=0;
//        int ill=0;
//        for(Character c:password.toCharArray()){
//            if(c>='a' && c<='z'){
//                hasArray[0]=1;
//            }else if(c>='A' && c<='Z'){
//                hasArray[1]=1;
//            }else if( c>='0' && c<='9'){
//                hasArray[2]=1;
//            }
//            if(c==pre){
//                con++;
//                if(con==3){
//                    con=0;
//                    ill++;
//                }
//            }else{
//                con=1;
//                pre=c;
//            }
//
//        }
//        int hasCnt=hasArray[0]+hasArray[1]+hasArray[2];
//        ans+=(3-hasCnt);
//
//        int addOrCut=0;
//        if(password.length()<6){
//            addOrCut=6-password.length();
//        }else if(password.length()>20){
//            addOrCut=password.length()-20;
//        }
//
//        ans+=(addOrCut-ans>0?addOrCut-ans:0);
//        ans+=(ill-ans>0?ill-ans:0);
//
//        return ans;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}