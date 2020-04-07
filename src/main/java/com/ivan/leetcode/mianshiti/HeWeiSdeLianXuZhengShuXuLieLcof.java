package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 * */
public class HeWeiSdeLianXuZhengShuXuLieLcof {

    @Test
    public void test(){
        int[][] matrix=findContinuousSequence(9);
        ShowUtil.showIntMatrix(matrix);

        int[][] matrix2=findContinuousSequence(15);
        ShowUtil.showIntMatrix(matrix2);
    }

    public int[][] findContinuousSequence(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

//    /**
//     * 双指针法
//     * */
//    public int[][] findContinuousSequence(int target) {
//        List<int[]> list=new ArrayList<>();
//        int start=1;
//        int end=2;
//        int sum=start+end;
//        while (start<end){
//            if(sum==target){
//                int total=end-start+1;
//                int[] temp=new int[total];
//                for(int i=0;i<total;i++){
//                    temp[i]=start+i;
//                }
//                list.add(temp);
//                sum=sum-start;
//                start++;
//            }else if(sum<target){
//                end++;
//                sum=sum+end;
//            }else{
//                sum=sum-start;
//                start++;
//            }
//        }
//        int[][] matrix=new int[list.size()][];
//        for(int i=0;i<list.size();i++){
//            matrix[i]=list.get(i);
//        }
//        return matrix;
//    }

//    /**
//     * 暴力法
//     * */
//    public int[][] findContinuousSequence(int target) {
//        List<List<Integer>> list=new ArrayList<>();
//        int i=1;
//        while (i<target){
//            int j=i;
//            int sum=0;
//            List<Integer> temp=new ArrayList<>();
//            while (sum<target){
//                sum=sum+j;
//                temp.add(j);
//                if(sum==target){
//                    list.add(temp);
//                }
//                j++;
//            }
//            i++;
//        }
//        if(list.size()==0){
//            return new int[0][0];
//        }
//        int[][] matrix=new int[list.size()][list.get(0).size()];
//        for(i=0;i<list.size();i++){
//            int[] temp=new int[list.get(i).size()];
//            for(int j=0;j<list.get(i).size();j++){
//                temp[j]=list.get(i).get(j);
//            }
//            matrix[i]=temp;
//        }
//        return matrix;
//    }
}
