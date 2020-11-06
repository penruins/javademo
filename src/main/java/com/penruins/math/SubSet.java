package com.penruins.math;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SubSet {
    public static Set<Set<Integer>> getSubSet(int[] set) {
        Set<Set<Integer>> result = new HashSet<>();
        int length = set.length;

        int times = 0;
        if(length == 0) {
            times = 0;
        } else {
            times = 1<<length;
        }

        for(int i=0;i<times;i++) {
            Set<Integer> subSet = new HashSet<>();
            int index = i;

            for(int j=0;j<length;j++) {
                if((index &1) == 1) {
                    subSet.add(set[j]);
                }
                index >>= 1;
            }
            result.add(subSet);
        }
        return result;
    }

    @Test
    public void test() {
        getSubSet(new int[]{1,2,3,4,6}).forEach(set -> {
            System.out.println(set);
        });
    }
}
