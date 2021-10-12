package com.bad_java.lectures._08;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NumberOptional<T extends Number & Comparable<String> & Serializable & Cloneable> {

    private T value;

    public NumberOptional(T value) {
        this.value = value;
    }

    public static <R extends Comparable> void method2(R num) {

    }

    public <R extends T> void method(R param) {
        R ref = null;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        if (isEmpty()) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOptional<?> that = (NumberOptional<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return isEmpty()
                ? "Optional.empty"
                : "Optional[" + value + ']';
    }
}
