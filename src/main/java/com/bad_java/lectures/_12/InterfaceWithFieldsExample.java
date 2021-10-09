package com.bad_java.lectures._12;

import java.util.IdentityHashMap;
import java.util.Map;

public class InterfaceWithFieldsExample {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(threadLocal.get());
        threadLocal.set("thread-local value");
        System.out.println(threadLocal.get());

        Holder<String> holder = new Holder<>(){};
        holder.setValue("value#1");
        System.out.println(holder.getValue());

        Dummy<String> dummy = new Dummy<>();
        dummy.setValue("value#2");
        System.out.println(dummy.getValue());

        Dummy<String> empty = new Dummy<>();
        System.out.println(empty.getValue());
    }
}

interface Holder<T> {

    Map<Holder<?>, Object> STORAGE = new IdentityHashMap<>();

    default Holder<T> setValue(T value) {
        STORAGE.put(this, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    default T getValue() {
        return (T) STORAGE.get(this);
    }
}

class Dummy<T> implements Holder<T> {}