package com.qinchao.common.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description
 *
 * @author qinchao
 * @since 2023/4/8 10:57
 */
public class DateUtils {

    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_PATTERN = "yyyy-MM-dd";

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String dateString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static String dateString(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String datetimeString(LocalDateTime datetime) {
        return datetime.format(DATE_TIME_FORMATTER);
    }

    public static String datetimeString(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime datetime(String datetime, String pattern) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime datetime(String datetime) {
        return LocalDateTime.parse(datetime, DATE_TIME_FORMATTER);
    }

    public static LocalDate date(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate date(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

}
