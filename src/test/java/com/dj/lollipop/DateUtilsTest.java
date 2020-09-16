package com.dj.lollipop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


class DateUtilsTest {

    @Test
    void scale() throws ParseException {

        String start = "2020-01-01 00:00:00";
        String end = "2021-01-01 00:00:01";

        List<Date> dateList = DateUtils.scale(start, end, Calendar.MONTH, 1);
        assertEquals(dateList.size(), 12);
        List<Date> callBack = new ArrayList<>();
        DateUtils.scale(start, end, Calendar.MONTH, 1, (Date s, Date e, Integer index) -> {
            callBack.add(s);
        });

        int i = 0;
        for (Date s : callBack) {
            assertEquals(dateList.get(i), s);
            i = i + 1;
        }
    }

    @Test
    void getDate() {
        String a = DateUtils.getDateStr(DateUtils.getDate(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:11");
        String b = DateUtils.getDateStr(DateUtils.getDate(System.currentTimeMillis()));
        assertEquals(a, b);
    }
}