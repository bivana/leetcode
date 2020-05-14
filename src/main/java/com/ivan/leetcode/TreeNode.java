package com.ivan.leetcode;

/**
 * 二叉树结构
 * */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode create(Integer[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        TreeNode[] treeNodes=new TreeNode[nums.length];
        treeNodes[0]=new TreeNode(nums[0]);
        if(nums.length>1){
            for(int i=1;i<nums.length;i++){
                if(nums[i]==null){
                    treeNodes[i]=null;
                }else{
                    treeNodes[i]=new TreeNode(nums[i]);
                }
                int parent=(i-1)/2;
                if(treeNodes[parent]!=null){
                    if((i&1)==1){
                        treeNodes[parent].left=treeNodes[i];
                    }else{
                        treeNodes[parent].right=treeNodes[i];
                    }
                }

            }
        }
        return treeNodes[0];
    }
}
