package com.zj.data.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
    public static String dateToWeek(Date datet) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        try {
            cal.setTime(datet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }





    /**获取当前时间的整点小时时间
     * @param date
     * @return
     */
    public static String getCurrHourTime(Date date){
        Calendar ca = Calendar.getInstance();
        date = ca.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }

    /**
     * 获取时间字符串的整数部分，然后并加1；
     * @return
     */
    public static String dateToTime(String date)
    {
        Integer result = null;
        String first = String.valueOf(date.charAt(0));
        String sencond = String.valueOf(date.charAt(1));
        if (first.equals("0"))
        {
            result=Integer.parseInt(sencond)+1;
        }
        else if(date.substring(0,2).equals("23"))
        {
            result=0;
        }
        else if (!first.equals("0"))
        {
            result=Integer.parseInt(date.substring(0,2))+1;
        }else {
            return "error";
        }

        return result.toString()+"时";

    }

    public static void main (String[] args) {
        String s = DateTools.dateToTime("");
        System.out.println(s);
    }

}
