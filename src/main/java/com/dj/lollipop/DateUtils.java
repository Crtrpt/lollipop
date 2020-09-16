package com.dj.lollipop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@FunctionalInterface
interface Action {
    void run(Date start, Date end, Integer index);
}

public class DateUtils {

    /**
     * @param start 开始时间
     * @param end   结束时间
     * @param tick  步长单位
     * @param step     步长
     */
    public static List<Date> scale(Date start, Date end, Integer tick, Integer step) {
        List<Date> ret = new ArrayList<>();
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Date startDate = startCalendar.getTime();
        do {
            startCalendar.add(tick, step);
            if (startCalendar.before(endCalendar)) {
                ret.add(startDate);
            } else {
                break;
            }
            startDate = startCalendar.getTime();
        } while (true);
        return ret;
    }

    /**
     * @param start  开始时间
     * @param end    结束时间
     * @param tick   步长单位
     * @param step   步长
     * @param action 要执行的动作
     */
    public static void scale(Date start, Date end, Integer tick, Integer step, Action action) {
        Integer index = 0;

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Date startDate = startCalendar.getTime();
        do {
            index++;
            startCalendar.add(tick, step);
            Date endDate = startCalendar.getTime();
            if (startCalendar.before(endCalendar)) {
                action.run(startDate, endDate, index);
            } else {
                break;
            }
            startDate = startCalendar.getTime();
        } while (true);
    }

    public static Date getDate(String dateStr, SimpleDateFormat simpleDateFormat) throws ParseException {
        return simpleDateFormat.parse(dateStr);
    }

    public static Date getDate(String dateStr, String format) throws ParseException {
        return getDate(dateStr, new SimpleDateFormat(format));
    }

    public static Date getDate(String dateStr) throws ParseException {
        return getDate(dateStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static Date getDate(Long timestamp) {
        return new Date(timestamp);
    }

    public static String getDateStr(Date date, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(date);
    }

    public static String getDateStr(Date date, String simpleDateFormat) {
        return getDateStr(date, new SimpleDateFormat(simpleDateFormat));
    }

    public static String getDateStr(Date date) {
        return getDateStr(date, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String getDateStr(Long timestamp, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(getDate(timestamp));
    }

    public static String getDateStr(Long timestamp, String format) {
        return getDateStr(timestamp, new SimpleDateFormat(format));
    }

    public static void scale(String start, String end, Integer tick, Integer step, Action action) throws ParseException {
        scale(getDate(start), getDate(end), tick, step, action);
    }

    public static List<Date> scale(String start, String end, Integer tick, Integer step) throws ParseException {
        return scale(getDate(start), getDate(end), tick, step);
    }
}
