package com.bad_java.lectures._12;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class BasicsFunctional {

    public static void main(String[] args) {
//        String s1 = somewhatLongOperation1();
//        String s2 = somewhatLongOperation2();
//        String s4 = somewhatLongOperation3();
//        String s3 = concatenate(s1, s2);

        // First-class citizen (объекты первого класса)
        // Side-effect (побочные эффекты)
        // Pure function (чистая функция)
        // High-order functions (функции высшего порядка)
        // N-arity (N-арность функций)
        BiFunction<Integer, Integer, Integer> adder = BasicsFunctional::add;

        Integer result4 = adder.apply(1, 2);
        Integer result1 = add(1, 2);
        int result2 = add(2, 3);
        int result3 = add(1, 2);

        BiFunction<Integer, Integer, Integer> result = someMethod(BasicsFunctional::add);
    }

    public static boolean getBoolean(int param) {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static BiFunction<Integer, Integer, Integer> someMethod(BiFunction<Integer, Integer, Integer> param) {
        return param;
    }
}
