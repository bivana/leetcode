package com.ivan.leetcode.questions;

import org.junit.Test;

/**
 * 176. 第二高的薪水
 * SQL架构
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
 *
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 * 通过次数99,606提交次数284,784
 * */
public class SecondHighestSalary {
//    @Test
//    public void test(){
//        System.out.println("SELECT\n" +
//                "                (SELECT DISTINCT\n" +
//                "                        Salary\n" +
//                "                        FROM\n" +
//                "                        Employee\n" +
//                "                        ORDER BY Salary DESC\n" +
//                "                        LIMIT 1 OFFSET 1) AS SecondHighestSalary");
//
//    }
}
