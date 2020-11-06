package com.penruins.java8;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class TimeTest {

    @Test
    public void demo1() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }
}
