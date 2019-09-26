package com.ivan.leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 *
 *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class MidNum {
    public static void main(String[] args){
        MidNum midNum=new MidNum();
        int[] nums1=new int[]{1,3,4,7};
        int[] nums2=new int[]{1,2,3,4,5,6,7,8,9,10};

        double mid=findMedianSortedArrays(nums1,nums2);
        System.out.println(mid);
    }

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        int k=(nums1.length+nums2.length+1)/2;
        double mid=0;
        //偶数
        if((nums1.length+nums2.length)%2==0){
            double midLeft=getMid(nums1,0,nums1.length-1,nums2,0,nums2.length-1,k);
            int k2=(nums1.length+nums2.length+2)/2;
            double midRight=getMid(nums1,0,nums1.length-1,nums2,0,nums2.length-1,k2);
            mid=(midLeft+midRight)/2.0;
        }else{
            //奇数，只求一次
            mid=getMid(nums1,0,nums1.length-1,nums2,0,nums2.length-1,k);
        }
        return mid;
    }

    /**
     * 求第k位数
     * */
    public static int getMid(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1=end1-start1+1;
        int len2=end2-start2+1;
        if(len1==0){
            return nums2[start2+k-1];
        }
        if(len2==0){
            return nums1[start1+k-1];
        }
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int j1=start1+Math.min(k/2,len1)-1;
        int j2=start2+Math.min(k/2,len2)-1;
        if(nums1[j1]<nums2[j2]){
            return getMid(nums1,j1+1,end1,nums2,start2,end2,k-(j1-start1+1));
        }else{
            return getMid(nums1,start1,end1,nums2,j2+1,end2,k-(j2-start2+1));
        }


    }


}
