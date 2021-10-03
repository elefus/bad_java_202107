package com.bad_java.lectures._08;

import java.lang.reflect.Method;

public class ComparableExample implements Comparable<Integer> {

    public static void main(String[] args) {
        for (Method declaredMethod : ComparableExample.class.getDeclaredMethods()) {
            System.out.println(declaredMethod + " = " + declaredMethod.isSynthetic());
        }
//        for (Constructor<?> declaredConstructor : ComparableExample.class.getDeclaredConstructors()) {
//            System.out.println(declaredConstructor + " = " + declaredConstructor.isSynthetic());
//        }
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
