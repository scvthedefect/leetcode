package cn.lawrence.leetcode.solution.easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class No1154DayOfYear {
    
    static No1154DayOfYear SAMPLE = new No1154DayOfYear();
    
    public static void main(String[] args) {
        test("2000-01-01");
        test("2019-02-01");
    }
    
    public static void test(String date) {
        int n = SAMPLE.dayOfYear(date);
        System.out.println(String.format("%s: %d", date, n));
    }
    
    public int dayOfYearCommon(String date) {
        String[] s = date.split("-");
        int year = Integer.valueOf(s[0]).intValue();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0; 
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] domLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // TODO 算出每月的天数总和
        
        return 0;
    }
    
    public int dayOfYear(String date) {
//        String[] sp = date.split("-");
//        boolean isLeap = (Integer.valueOf(sp[0]) - 2000) % 4 == 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            return cal.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            return 0;
        }
    }

}
