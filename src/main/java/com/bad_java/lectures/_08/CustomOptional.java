package com.bad_java.lectures._08;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomOptional<T> {

    private T value;

    public CustomOptional(T value) {
        this.value = value;
    }

    public void ifPresent(Consumer<T> action) {
        if (value != null) {
            action.accept(value);
        }
    }

    public CustomOptional<T> filter(Predicate<T> predicate) {
        if (value == null) {
            return this;
        }
        if (predicate.test(value)) {
            return this;
        }
        return new CustomOptional<>(null);
    }

    public <R> CustomOptional<R> map(Function<T, R> function) {
        if (value == null) {
            return new CustomOptional<>(null);
        }
        R result = function.apply(value);
        return new CustomOptional<>(result);
    }

    public T orElse(T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public <E extends Throwable> T orElseThrow(E exception) throws E {
        if (value == null) {
            throw exception;
        }
        return value;
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
