package com.bad_java.lectures._12;

import java.util.function.BiFunction;

public class Test {

    public static void main(String[] args) {
//        String s1 = somewhatLongOperation1();
//        String s2 = somewhatLongOperation2();
//        String s4 = somewhatLongOperation3();
//        String s3 = concatenate(s1, s2);

        // First-class citizen (объекты первого класса)
        // Pure function (чистая функция)
        // High-order functions (функции высшего порядка)
        BiFunction<Integer, Integer, Integer> adder = Test::add;


        Integer result4 = adder.apply(1, 2);
        Integer result1 = add(1, 2);
        int result2 = add(2, 3);
        int result3 = add(1, 2);

        BiFunction<Integer, Integer, Integer> result = someMethod(Test::add);
    }

    public static Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static BiFunction<Integer, Integer, Integer> someMethod(BiFunction<Integer, Integer, Integer> param) {
        return param;
    }
}
