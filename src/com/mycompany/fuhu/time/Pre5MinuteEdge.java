package com.mycompany.fuhu.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
/*
return the previous 5 minutes window start timestamp
e.g.
current zoneId = Asia/Shanghai
current ldt = 2020-07-08T21:39
ret = 1594215300
 */
public class Pre5MinuteEdge {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("current zoneId = " + zoneId);
        long currTimeMillis = System.currentTimeMillis();
        LocalDateTime ldt = Instant.ofEpochMilli(currTimeMillis).atZone(zoneId).truncatedTo(ChronoUnit.MINUTES).toLocalDateTime();
        System.out.println("current ldt = " + ldt);
        int diff = ldt.getMinute() % 5;
        long ret =  TimeUnit.MILLISECONDS.toSeconds(
                ldt.minus((diff), ChronoUnit.MINUTES)
                        .atZone(zoneId)
                        .toInstant()
                        .toEpochMilli());
        System.out.println("ret = " + ret);
    }
}
