package com.penruins.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {
    static int max = 1000000;
    static List<String> values = new ArrayList<>();
    static {
        for(int i=0;i<max;i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    public void sequential_sort() {
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("sequential sort took: %d ms",millis));
    }
    public void parallel_sort() {
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("sequential sort took: %d ms",millis));
    }

    @Test
    public void test() {
        sequential_sort();
        parallel_sort();
    }

}
