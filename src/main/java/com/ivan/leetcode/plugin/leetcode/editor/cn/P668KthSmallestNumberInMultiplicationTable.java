package com.ivan.leetcode.plugin.leetcode.editor.cn;
//668 乘法表中第k小的数
//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 二分查找 👍 220 👎 0

public class P668KthSmallestNumberInMultiplicationTable{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l=1;
        int r=m*n;
        while (l<r){
            int mid=(l+r)>>1;
            int cnt=getCnt(mid,m,n);
            if(cnt>=k){//在左边
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }

    //比k小的个数
    public int getCnt(int x,int m,int n){
        int ans=0;
        for(int i=1;i<=m;i++){
            if(x/i==0){
                break;
            }
            ans+=Math.min(n,x/i);
        }
        return ans;
    }

//        int n, m, k;
//        public int findKthNumber(int _m, int _n, int _k) {
//            n = Math.min(_m, _n); m = Math.max(_m, _n); k = _k;
//            int l = 1, r = m * n;
//            while (l < r) {
//                int mid = l + r >> 1, cnt = getCnt(mid);
//                if (cnt >= k) r = mid;
//                else l = mid + 1;
//            }
//            return r;
//        }
//        int getCnt(int mid) {
//            int a = 0, b = 0;
//            for (int i = 1; i <= n; i++) {
//                if (i * m < mid) {
//                    a += m;
//                } else {
//                    if (mid % i == 0 && ++b >= 0) a += mid / i - 1;
//                    else a += mid / i;
//                }
//            }
//            return a + b;
//        }


}
//leetcode submit region end(Prohibit modification and deletion)

}