package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeSetTest {

    @Test
    void name() {
        TreeSet<Integer> values = new TreeSet<>();
        values.add(1);
        boolean result = values.add(1);
        if (result) {
            // ....
        }

        assertThat(values.add(1)).isFalse();

        assertThat(values.add(2)).isTrue();
        values.add(-1);
        values.add(5);
        values.add(10);
        values.add(8);
        values.add(61);
        System.out.println(values);

        SortedSet<Integer> head = values.headSet(6);
        System.out.println(head);

        SortedSet<Integer> tail = values.tailSet(6);
        System.out.println(tail);

        NavigableSet<Integer> subSet = values.subSet(2, true, 8, true);
        System.out.println(subSet);

        assertThat(values.higher(10)).isEqualTo(61);
        assertThat(values.ceiling(10)).isEqualTo(10);
        assertThat(values.ceiling(62)).isNull();
        assertThat(values.lower(10)).isEqualTo(8);
        assertThat(values.floor(10)).isEqualTo(10);
    }
}
