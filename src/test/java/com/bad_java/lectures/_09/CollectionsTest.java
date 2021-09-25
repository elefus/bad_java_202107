package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest {

    @Test
    void name() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
//        strings.add(new Object());

//        List<String> checkedStrings = Collections.checkedList(strings, String.class);
//        List raw = checkedStrings;
//        raw.add(new Object());
//
//        System.out.println(strings);
//
//        Object obj = raw.get(2);
//        System.out.println(obj);
//
//        String str = strings.get(2);
//        System.out.println(str);

        List<Integer> source = Arrays.asList(1, 2, 3);
        source.set(0, 10);

        source = List.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 0, 0, 1, 2);
//        source.set(0, 10); UnsupportedOperationException

        List<Integer> target = List.of(1, 2);
        int firstOccurrence = Collections.indexOfSubList(source, target);
        assertThat(firstOccurrence).isEqualTo(0);

        int secondStartingPoint = firstOccurrence + target.size();

        List<Integer> subList = source.subList(secondStartingPoint, source.size());
        int secondOccurrence = secondStartingPoint + Collections.indexOfSubList(subList, target);
        assertThat(secondOccurrence).isEqualTo(7);
    }
}
