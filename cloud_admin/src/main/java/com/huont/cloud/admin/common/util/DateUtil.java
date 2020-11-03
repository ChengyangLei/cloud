package com.huont.cloud.admin.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xbird
 * @title: DateUtil
 * @projectName dsedevcommon
 * @description: TODO
 * @date 2019/5/2916:44
 */
public class DateUtil {

    private Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HHMMSS1 = "yyyy/MM/dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取指定月的开始日期
     *
     * @param currentDate
     * @return
     */
    public static Date getStartDate(String currentDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(currentDate));
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 获取指定月的结束日期
     *
     * @param currentDate
     * @return
     */
    public static Date getEndDate(String currentDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(currentDate));
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

    /**
     * 将两个时间差值进行转换
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static String durationBetweenDay(String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HHMMSS);
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);
        Long ms = end.getTime() - start.getTime();
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;
        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        StringBuilder sb = new StringBuilder();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }
        return sb.toString();
    }


}
