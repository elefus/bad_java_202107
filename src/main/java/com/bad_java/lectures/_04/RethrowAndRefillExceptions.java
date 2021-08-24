package com.bad_java.lectures._04;

public class RethrowAndRefillExceptions {

    public static void main(String[] args) throws Throwable {
        lib();

    }

    public static void lib() throws Throwable {
        try {
            internalMethod();
        } catch (Throwable ex) {
            ex = null;
            throw ex; // rethrow
        }
    }

    public static void internalMethod() {
        throw new IllegalArgumentException();
    }


}
