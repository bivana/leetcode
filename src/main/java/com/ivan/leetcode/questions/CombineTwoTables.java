package com.ivan.leetcode.questions;

/**
 * 175. 组合两个表
 * SQL架构
 * 表1: Person
 *
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 *
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 *
 *
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 *
 *
 *
 * FirstName, LastName, City, State
 * 通过次数129,792提交次数178,743
 * */
public class CombineTwoTables {
//    select a.FirstName,a.LastName,b.City,b.State
//    from Person a
//    left join Address b
//            on a.PersonId=b.PersonId
}
