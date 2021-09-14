package com.bad_java.lectures._08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class VarianceTest {

    @Test
    void name() {
        // Совместимость присваивания
        String str = "123";
        Object obj = str;

        // Массивы - ковариантны
        String[] strings = {};
        Object[] objects = strings;

        // <? extends T> - ковариантен
        List<Integer> intList2 = null;
        List<? extends Number> numList2 = intList2;

        // Дженерики - инварианты
        CustomOptional<String> strOpt = null;
//        CustomOptional<Object> objOpt = strOpt;

        // <? super T> - контрвариантен
        List<Number> numList = null;
        List<? super Integer> intList = numList;
    }
}

class A {

    public Number method() throws Exception {
        return null;
    }
}

class B extends A {

    // Список исключений ковариантен
    // Возвращаемые значения метода ковариантны
    @Override
    public Integer method() throws IOException {
        return null;
    }
}
