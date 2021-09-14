package com.ivan.leetcode;

public class Test {

    public static void main(String[] args){
        int l=recursionBinarySearch(new int[]{1,2,3,4,5,6,7,8,9,10},1,0,9);
    }


    /**
     * 使用递归的二分查找
     *title:recursionBinarySearch
     *@param arr 有序数组
     *@param key 待查找关键字
     *@return 找到的位置
     */
    public static int recursionBinarySearch(int[] arr,int key,int low,int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;            //初始中间位置
        System.out.println(middle);
        if (arr[middle] > key) {
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }


}
