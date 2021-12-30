package com.smartoscfintech.iportal.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {
    public static Long toMilliSecond(LocalDateTime dateTime) {
        if (Objects.isNull(dateTime)) {
            return null;
        }

        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long toMilliSecond(LocalDate date) {
        if (Objects.isNull(date)) {
            return null;
        }

        return date.atTime(LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime convertLongToLocalDateTime(Long timestampLong) {
        if (Objects.isNull(timestampLong)) {
            return null;
        }

        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampLong), TimeZone
                .getDefault().toZoneId());
    }
    public static LocalDateTime convertLongToLocalDateTime(Long time, String timezone) {
        if (Objects.isNull(time)) {
            return null;
        }

        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.of(timezone));
    }
    public static String getStrDate(Long time, String format, String timezone) {
        if (Objects.isNull(time)) {
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        return formatter.format(new Date(time));
    }

    public static Timestamp getTimeStamp1(Timestamp timestamp) {
        Timestamp result;
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.DAY_OF_WEEK, 1);
        result = new Timestamp(cal.getTime().getTime());
        return result;
    }

    public static Timestamp getTimeStamp(Timestamp timestamp) {
        Timestamp result;
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.SECOND, 86399);
        result = new Timestamp(cal.getTime().getTime());
        return result;
    }

    public static String getTimezone(String timezone) {
        return StringUtils.isEmpty(timezone) ? TimeZone.getDefault().getID() : timezone;
    }

    public static LocalDateTime convertToSystemTime(LocalDateTime dateTime, String timezone) {
        if (Objects.isNull(dateTime)) {
            return null;
        }

        ZonedDateTime systemTime = dateTime.atZone(ZoneId.of(timezone)).withZoneSameInstant(ZoneId.systemDefault());
        return systemTime.toLocalDateTime();
    }

    public static List<Integer> getWeeksInMonth(String timezone) {
        LocalDate current = LocalDate.now(ZoneId.of(timezone));
        TemporalField weekField = WeekFields.ISO.weekOfWeekBasedYear();
        int firstWeek = current.with(TemporalAdjusters.firstDayOfMonth()).get(weekField);
        int lastWeek = current.with(TemporalAdjusters.lastDayOfMonth()).get(weekField);
        return IntStream.rangeClosed(firstWeek, lastWeek).boxed().collect(Collectors.toList());
    }
}
