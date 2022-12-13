package com.ivan.leetcode.algo;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

    @Test
    public void test(){
//        Assert.assertEquals(3,binarySearch(new int[]{1,2,4,4,4,6,7},4));
//        Assert.assertEquals(0,binarySearch(new int[]{1,2,4,4,4,6,7},1));
//        Assert.assertEquals(-1,binarySearch(new int[]{1,2,4,4,4,6,7},8));
//        Assert.assertEquals(6,binarySearch(new int[]{1,2,4,4,4,6,7},7));
//        Assert.assertEquals(2,binarySearchLeft(new int[]{1,2,4,4,4,6,7},4));
//        Assert.assertEquals(0,binarySearchLeft(new int[]{1,2,4,4,4,6,7},1));
//        Assert.assertEquals(-1,binarySearchLeft(new int[]{1,2,4,4,4,6,7},8));
//        Assert.assertEquals(6,binarySearchLeft(new int[]{1,2,4,4,4,6,7},7));
//        Assert.assertEquals(4,binarySearchRight(new int[]{1,2,4,4,4,6,7},4));
//        Assert.assertEquals(0,binarySearchRight(new int[]{1,2,4,4,4,6,7},1));
//        Assert.assertEquals(-1,binarySearchRight(new int[]{1,2,4,4,4,6,7},8));
//        Assert.assertEquals(6,binarySearchRight(new int[]{1,2,4,4,4,6,7},7));
//        Assert.assertEquals(1,binarySearchLtTarget(new int[]{1,2,4,4,4,6,7},4));
//        Assert.assertEquals(-1,binarySearchLtTarget(new int[]{1,2,4,4,4,6,7},1));
//        Assert.assertEquals(6,binarySearchLtTarget(new int[]{1,2,4,4,4,6,7},8));
//        Assert.assertEquals(5,binarySearchLtTarget(new int[]{1,2,4,4,4,6,7},7));
        Assert.assertEquals(5,binarySearchGtTarget(new int[]{1,2,4,4,4,6,7},4));
        Assert.assertEquals(1,binarySearchGtTarget(new int[]{1,2,4,4,4,6,7},1));
        Assert.assertEquals(-1,binarySearchGtTarget(new int[]{1,2,4,4,4,6,7},8));
        Assert.assertEquals(-1,binarySearchGtTarget(new int[]{1,2,4,4,4,6,7},7));
    }

    /**
     * 寻找大于target的最小值
     * */
    public int binarySearchGtTarget(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<r){
            int mid=(l+r)>>1;
            if(array[mid]<=target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return array[l]>target?l:-1;
    }

    /**
     * 寻找小于target的最大值
     * */
    public int binarySearchLtTarget(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<r){
            int mid=(l+r+1)>>1;
            if(array[mid]>=target){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        return array[r]<target?r:-1;
    }

    /**
     * 寻找右侧边界
     * */
    public int binarySearchRight(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<r){
            int mid=(l+r+1)>>1;
            if(array[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return array[r]==target?r:-1;
    }

    /**
     * 寻找左侧边界
     * */
    public int binarySearchLeft(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<r){
            int mid=(l+r)>>1;
            if(array[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return array[l]==target?l:-1;
    }


    /**
     * 最简单的二分，不会出错，判断目标值是否在array中
     * */
    public int binarySearch(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}
