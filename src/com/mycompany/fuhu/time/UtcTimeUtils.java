package com.mycompany.fuhu.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class UtcTimeUtils {

    public String getCurrentUtcTime(String queryTimeFormat, int secondsOffset) {

        DateFormat dateFormat = new SimpleDateFormat(queryTimeFormat);
        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        System.out.println("date: "  + date);
        calendar.add(Calendar.MINUTE,secondsOffset);
        String dateString = dateFormat.format(calendar.getTime());
        System.out.println("date str: "  + dateString);
        //Convert to UTC
        LocalDateTime ldt = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(queryTimeFormat));
        System.out.println("ldt: "  + date);
        ZonedDateTime instant = ZonedDateTime.of(ldt, ZoneId.of("Asia/Shanghai"));
        System.out.println("zdt: "  + instant);
        String utc = instant.withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime().toString();

        return utc;
    }
    public static void main(String argv[]){
        UtcTimeUtils utcTimeUtils = new UtcTimeUtils();
        String timestamp=utcTimeUtils.getCurrentUtcTime("yyyy-MM-dd HH:mm:ss", 3);
        System.out.println("timestamp = " + timestamp);
    }
}
