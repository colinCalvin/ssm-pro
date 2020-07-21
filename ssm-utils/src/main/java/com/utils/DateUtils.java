package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 长歌哲理
 * @Description: 日期与字符串相互转换工具类
 */
public class DateUtils {

    /**
     * @Author 长歌哲理
     * @Description 日期转换为字符串
     * @Param [date, str]
     * @return java.lang.String
     **/
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * @Author 长歌哲理
     * @Description 字符串转换为日期
     * @Param [str, pattern]
     * @return java.util.Date
     **/
    public static Date stringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
