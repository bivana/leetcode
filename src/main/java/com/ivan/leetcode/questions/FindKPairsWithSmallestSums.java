package com.ivan.leetcode.questions;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 373. 查找和最小的K对数字
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 *
 * 提示:
 *
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 * */
public class FindKPairsWithSmallestSums {

    @Test
    public void test(){
        System.out.println(">>>>>>>>>>>>>>>4");
        ShowUtil.showListMatrix(kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},10));
        System.out.println(">>>>>>>>>>>>>>>3");
        ShowUtil.showListMatrix(kSmallestPairs(new int[]{1,2},new int[]{3},3));
        System.out.println(">>>>>>>>>>>>>>>1");
        ShowUtil.showListMatrix(kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));
        System.out.println(">>>>>>>>>>>>>>>2");
        ShowUtil.showListMatrix(kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int i=0;
        int j=0;
        List<List<Integer>> rs=new ArrayList<>();
        addRs(rs,nums1[0],nums2[0]);
        int nus1Lst=nums1.length-1;
        int nus2Lst=nums2.length-1;
        while (rs.size()<k&&i<nums1.length&&j<nums2.length){
            if(i==nus1Lst&&j==nus2Lst){
                break;
            }else if(i==nus1Lst){
                j++;
                addRs(rs,nums1[i],nums2[j]);
            }else if(j==nus2Lst){
                i++;
                addRs(rs,nums1[i],nums2[j]);
            }else{
                int jAdd=nums1[i]+nums2[j+1];
                int iAdd=nums1[i+1]+nums2[j];
                if(iAdd==jAdd){
                    addRs(rs,nums1[i+1],nums2[j]);
                    if(rs.size()<k){
                        addRs(rs,nums1[i],nums2[j+1]);
                        j++;
                    }
                    i++;
                }else if(iAdd<=jAdd){
                    i++;
                    addRs(rs,nums1[i],nums2[j]);
                }else{
                    j++;
                    addRs(rs,nums1[i],nums2[j]);
                }
            }

        }
        return rs;
    }

    public void addRs(List<List<Integer>> list,Integer a,Integer b){
        List<Integer> ans=new ArrayList<>();
        ans.add(a);
        ans.add(b);
        list.add(ans);
    }
}
