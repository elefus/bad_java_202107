package com.bad_java.lectures._12;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapApiTest {

    @Test
    void name() {
        HashMap<String, Integer> metrics = new HashMap<>();

        Integer connections = metrics.get("connections");
        if (connections == null) {
            metrics.put("connections", 1);
        }



        metrics.merge("users", 1, Integer::sum);
        metrics.merge("users", 1, Integer::sum);
        metrics.merge("users", 1, Integer::sum);

        assertThat(metrics.get("users")).isEqualTo(3);

        metrics.computeIfAbsent("users", String::length);
        metrics.putIfAbsent("customers", 55);

        metrics.compute("shops", (key, current) -> {
            return 55;
        });

        for (String key : metrics.keySet()) {

        }

        for (Integer value : metrics.values()) {

        }

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
        }

        metrics.forEach((key, value) -> System.out.println("key = {" + key + "}, value = {" + value + "}"));
    }
}
