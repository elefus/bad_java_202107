package com.bad_java.lectures;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomOptional<T> {

    private T value;

    public CustomOptional(T value) {
        this.value = value;
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
        CustomOptional<?> that = (CustomOptional<?>) o;
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
