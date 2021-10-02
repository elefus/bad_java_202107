package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysTest {

    @Test
    void name() {
        int[] ints = new int[10];

        int[] ints1 = Arrays.copyOf(ints, 1000);

        Arrays.fill(ints, 42);
        Arrays.binarySearch(ints, 2); // log2(n)
//        Arrays.mismatch()
//        Arrays.compare()
        Arrays.setAll(ints, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int i) {
                return i * i;
            }
        });


        // 0 1 2 -1 2 2
        // 0 1 3 2 4 6
        int[] source = {0, 1, 2, -1, 2, 2};
        Arrays.parallelPrefix(source, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        assertThat(source).containsExactly(0, 1, 3, 2, 4, 6);

//        Arrays.sort();


        List<String> strings = List.of("abc", "weq");
        Object[] objects = strings.toArray();

        String[] stringsArr = new String[strings.size()];
        strings.toArray(stringsArr);

        String[] res = strings.toArray(new String[0]);

        IntFunction<String[]> stringArrayGenerator = new IntFunction<String[]>() {
            @Override
            public String[] apply(int size) {
                return new String[size];
            }
        };

        String[] size10 = stringArrayGenerator.apply(10);
        String[] size20 = stringArrayGenerator.apply(20);

        String[] res2 = strings.toArray(stringArrayGenerator);
        String[] res3 = strings.toArray(String[]::new);
    }
}
