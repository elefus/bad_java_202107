package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    void name() {
        TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put("A", 1);
        map.put("B", 1);
        map.put(".", 1);
        map.put("_", 1);

        System.out.println(map);
    }
}
