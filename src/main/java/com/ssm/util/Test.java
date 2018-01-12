package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        date = getBeforeDay(date);
        System.out.println(sdf.format(date));
    }
    public static Date getBeforeDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -12);//-1今天的时间减一天
        date = calendar.getTime();
        return date;
    }
}
