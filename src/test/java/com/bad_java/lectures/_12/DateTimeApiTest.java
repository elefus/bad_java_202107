package com.bad_java.lectures._12;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateTimeApiTest {

    @Test
    void name() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusHours(22);
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusDays(2).plusHours(20));

        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        Duration between = Duration.between(LocalDateTime.of(2000, 10, 10, 0, 0), LocalDateTime.now());
        System.out.println(between.toDays());

        Instant now = Instant.now();
    }
}
