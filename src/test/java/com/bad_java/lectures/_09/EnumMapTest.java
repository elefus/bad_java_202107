package com.bad_java.lectures._09;

import com.bad_java.lectures._03.Season;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapTest {

    @Test
    void name() {
        assertThat(Season.UNKNOWN.ordinal()).isEqualTo(0);
        assertThat(Season.AUTUMN.ordinal()).isEqualTo(4);

        EnumMap<Season, String> map = new EnumMap<>(Season.class);
        map.put(Season.SPRING, "Весна");
        assertThat(map).hasSize(1);
        assertThat(map.get(Season.SPRING)).isEqualTo("Весна");

        WeakReference<Integer> weak = new WeakReference<>(new Integer(100));

    }
}
