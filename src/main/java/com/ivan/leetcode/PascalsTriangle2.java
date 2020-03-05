package com.ivan.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 通过次数41,279提交次数68,519
 * */
public class PascalsTriangle2 {

    @Test
    public void test(){
        Assert.assertArrayEquals(new Integer[]{1,3,3,1},getRow(3).toArray());
    }

    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        if(rowIndex==0){
            list.add(1);
            return list;
        }
        list=getRow(list,rowIndex);
        return list;
    }

    public List<Integer> getRow(List<Integer> list,int remainRow){
        List<Integer> newList=new ArrayList<>(list.size()+1);
        newList.add(1);
        for(int i=0;i<list.size()-1;i++){
            newList.add(list.get(i)+list.get(i+1));
        }
        newList.add(1);
        list=newList;
        remainRow--;
        if(remainRow>0){
            list=getRow(list,remainRow);
        }
        return list;
    }
}
