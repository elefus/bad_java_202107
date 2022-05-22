package com.bad_java.lectures._06;

public class StringJoiner {

    public String join(String delimiter, String...strings) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return String.join(delimiter, strings);
    }
}
