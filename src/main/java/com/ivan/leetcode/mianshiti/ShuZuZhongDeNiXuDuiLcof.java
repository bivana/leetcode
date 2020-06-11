package com.ivan.leetcode.mianshiti;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 通过次数20,646提交次数45,625
 * */
public class ShuZuZhongDeNiXuDuiLcof {

    @Test
    public void test(){
        Assert.assertEquals(4,reversePairs(new int[]{1,3,2,3,1}));
        Assert.assertEquals(5,reversePairs(new int[]{7,5,6,4}));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        // 离散化：使得数字更紧凑，节约树状数组的空间
        // 1、使用二分搜索树是为了去掉重复元素
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            treeSet.add(nums[i]);
        }

        // 2、把排名存在哈希表里方便查询
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rankIndex = 1;
        for (Integer num : treeSet) {
            rankMap.put(num, rankIndex);
            rankIndex++;
        }

        int count = 0;
        // 在树状数组内部完成前缀和的计算
        // 规则是：从后向前，先给对应的排名 + 1，再查询前缀和
        FenwickTree fenwickTree = new FenwickTree(rankMap.size());

        for (int i = len - 1; i >= 0; i--) {
            int rank = rankMap.get(nums[i]);
            fenwickTree.update(rank, 1);
            count += fenwickTree.query(rank - 1);
        }
        return count;
    }

    private class FenwickTree {
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        /**
         * 单点更新：将 index 这个位置 + delta
         *
         * @param i
         * @param delta
         */
        public void update(int i, int delta) {
            // 从下到上，最多到 size，可以等于 size
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }


        // 区间查询：查询小于等于 tree[index] 的元素个数
        // 查询的语义是「前缀和」
        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }

//    //分治排序  不断二分，返回
//    public int reversePairs(int[] nums) {
//        if(nums==null||nums.length<=1){
//            return 0;
//        }
//        return partitionPairs(nums,0,nums.length-1);
//    }
//
//    //分治，不断二分
//    private int partitionPairs(int[] nums,int start,int end){
//        if(start==end){
//            return 0;
//        }
//        int mid=(start+end)>>>1;
//        int left=partitionPairs(nums,start,mid);
//        int right=partitionPairs(nums,mid+1,end);
//        int merge=merge(nums,start,mid,mid+1,end);
//        return left+right+merge;
//    }
//
//    //合并
//    private int merge(int[] nums,int start1,int end1,int start2,int end2){
//        int[] temp=new int[end2-start1+1];
//        int count=0;
//        int k=0;
//        int i=start1;
//        int j=start2;
//        while (i<=end1 && j<=end2){
//            if(nums[i]<=nums[j]){
//                temp[k]=nums[i];
//                i++;
//            }else{
//                count+=end1-i+1;
//                temp[k]=nums[j];
//                j++;
//            }
//            k++;
//        }
//        if(i<=end1){
//            System.arraycopy(nums,i,temp,k,end1-i+1);
//        }else{
//            System.arraycopy(nums,j,temp,k,end2-j+1);
//        }
//        System.arraycopy(temp,0,nums,start1,temp.length);
//        return count;
//    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }



    //插入排序
    public int reversePairs2(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }
        int ans=0;
        //插入排序计算
        for(int i=1;i<nums.length;i++){
            for(int j=i;j>0;j--){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                    ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
