package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class IterableTest {

    @Test
    void name() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iter = list.iterator();


        // fail-fast
//        iter.remove();
//        while (iter.hasNext()) {
//            Integer elem = iter.next();
//        }
//
//        iter.next();
//        iter.next();
//        iter.next();

        iter.next();
        iter.hasNext(); // true
        list.remove((Integer)2);
        iter.next();


        // fail-safe

        iter.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        for (Integer integer : list) {

        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        // internal iteration
        list.forEach(System.out::println);


        int[] arr = {1, 2, 3};
        for (int i : arr) {

        }
    }
}
