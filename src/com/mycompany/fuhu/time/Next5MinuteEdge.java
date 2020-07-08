package com.mycompany.fuhu.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
/*
Return the seconds to the next 5 minutes window + offset. unit is ms.
 e.g.
ldt=2020-07-08T21:22:16.864
secondsToNextInterval: 164000
offset: 10 (s)
res: 174000 (m)s
 */

public class Next5MinuteEdge {
    private static final int SECONDS_TO_MILLIS = 1000;
    private static final int ONE_MINUTE_IN_SECONDS = 60;
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        int offset = 10;
        long secondsToNextInterval = 0;
        long intervalMins = 5;
        long currentTime = System.currentTimeMillis();
        LocalDateTime ldt = Instant.ofEpochMilli(currentTime).atZone(zoneId).toLocalDateTime();
        System.out.println("ldt=" + ldt);
        secondsToNextInterval = (intervalMins * ONE_MINUTE_IN_SECONDS * SECONDS_TO_MILLIS
                - ((ldt.getMinute() % intervalMins * SECONDS_TO_MILLIS * ONE_MINUTE_IN_SECONDS) +
                (ldt.getSecond() * SECONDS_TO_MILLIS)));
        long res = secondsToNextInterval + offset * SECONDS_TO_MILLIS;
        System.out.println("secondsToNextInterval: " + secondsToNextInterval + "\n" +
                         "offset: "  + offset  +"\n" +
                "res: "  + res);
    }
}