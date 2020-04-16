package com.ivan.leetcode.mianshiti;

import com.ivan.leetcode.util.ShowUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数41,519提交次数69,617
 * */
public class ZuiXiaoDeKgeShuLcof {

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2,2,3},getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8));

        Assert.assertArrayEquals(new int[]{1,2},getLeastNumbers(new int[]{3,2,1},2));
        Assert.assertArrayEquals(new int[]{0},getLeastNumbers(new int[]{0,1,2,1},1));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||arr.length==0){
            return new int[]{};
        }
        quickFind(arr,0,arr.length-1,k);
        int[] res=new int[k];
        System.arraycopy(arr,0,res,0,k);
        return res;
    }

    public void quickFind(int[] arr,int start,int end,int k){
        if(start>=end){
            return;
        }
        int pivot=partition(arr,start,end);
        if(pivot==k){
            return;
        }else if(pivot<k){
            quickFind(arr,pivot+1,end,k);
        }else{
            quickFind(arr,start,pivot-1,k);
        }

    }

    public int partition(int[] arr,int start,int end){
        int pivot=arr[start];
        int left=start;
        int right=end;
        while (left!=right){
            while (right>left && arr[right]>pivot){
                right--;
            }
            while (left<right && arr[left]<=pivot ){
                left++;
            }
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        int p = arr[left];
        arr[left] = arr[start];
        arr[start] = p;
        return left;
    }




    /**
     * 堆
     * */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }
}
