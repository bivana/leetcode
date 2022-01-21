package com.ivan.leetcode.questions;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 1154. 一年中的第几天
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 *
 * 提示：
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * 通过次数23,112提交次数37,519
 * */
public class DayOfTheYear {

    @Test
    public void test(){
        Assert.assertEquals(9,dayOfYear("2019-01-09"));
        Assert.assertEquals(41,dayOfYear("2019-02-10"));
        Assert.assertEquals(60,dayOfYear("2003-03-01"));
        Assert.assertEquals(61,dayOfYear("2004-03-01"));
    }

    public int dayOfYear(String date) {
        int year=Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(5,7));
        int day=Integer.parseInt(date.substring(8,10));
        int ans=day;
        while (--month>0){
            switch (month){
                case 1: case 3: case 5: case 7 : case 8: case 10: case 12:
                    ans+=31;
                    break;
                case 4: case 6: case 9: case 11:
                    ans+=30;
                    break;
                case 2:
                    boolean isR=(year%4==0&&year%100!=0)||year%400==0;
                    if (isR){
                        ans+=29;
                    }else{
                        ans+=28;
                    }
                    break;
            }
        }
        return ans;
    }
}
