package com.bad_java.lectures._14.library.util;

import java.util.function.Predicate;

public final class LambdaUtils {

    private LambdaUtils() {
    }

    public static <T> Predicate<T> wrapChecked(CheckedPredicate<T> predicate) {
        return value -> {
            try {
                return predicate.test(value);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public interface CheckedPredicate<T> {

        boolean test(T value) throws Exception;
    }
}