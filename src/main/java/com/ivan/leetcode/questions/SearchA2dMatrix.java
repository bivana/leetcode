package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 通过次数42,699提交次数112,792
 * */
public class SearchA2dMatrix {

    @Test
    public void test(){
        Assert.assertEquals(false,searchMatrix(new int[][]{{1}},2));

        Assert.assertEquals(true,searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3));
        Assert.assertEquals(false,searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},13));
    }

    //二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int start=0;
        int end=matrix.length*matrix[0].length-1;
        while (start<=end){
            int mid=(start+end)>>>1;
            int i=mid/matrix[0].length;
            int j=mid%matrix[0].length;
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

}
