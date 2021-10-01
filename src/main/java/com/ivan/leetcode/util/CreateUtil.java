package com.ivan.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateUtil {
    public static List<List<String>> createStringMatrix(String[][] matrix){
        List<List<String>> rs=new ArrayList<>();
        if(matrix!=null){
            for(String[] array :matrix){
                rs.add(Arrays.asList(array));
            }
        }
        return rs;
    }
}
