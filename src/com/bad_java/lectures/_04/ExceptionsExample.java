package com.bad_java.lectures._04;

import lombok.SneakyThrows;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class ExceptionsExample {

    public static void main(String[] args) {
        System.out.println("main::enter");
        noThrowsMethod();
        System.out.println("main::exit");

        RuntimeException runtimeException = new RuntimeException();
        System.out.println("line between");
        throw runtimeException;

//        throwsUnchecked(new Exception());
//        sneaky();
    }

    public static void multiCatch() {
        try {
            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new SQLException();
            } else {
                throw new IllegalArgumentException("username");
            }
        } catch (SQLException | IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            Object obj = ex;
            IllegalArgumentException a = (IllegalArgumentException) obj;
            if (ex.getClass() == SQLException.class) {
                //..
            } else if (ex.getClass() == IllegalArgumentException.class) {
                //..
            }

            ex.printStackTrace();
        }
    }

    public static void noThrowsMethod() {
        System.out.println("noThrowsMethod::enter");
        try {
            method();
            System.out.println("After method");
            System.out.println(0 / 0);
            throw new Throwable();
        } catch (IllegalArgumentException ex) {
            String param = ex.getMessage();
        } catch (RuntimeException ex) {
            System.out.println("Got you!" + ex);
        } catch (Exception ex) {
            System.out.println("Caught Exception: " + ex);
        } catch (Throwable ex) {
            System.out.println("Caught Throwable: " + ex);
        }
        System.out.println("noThrowsMethod::exit");
    }

    /**
     *
     * @throws SQLException asdasd
     * @throws IllegalArgumentException adasdsa
     */
    public static void method() throws SQLException, IllegalArgumentException {
        System.out.println("method::enter");
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new SQLException();
        } else {
            throw new IllegalArgumentException("username");
        }
//        System.out.println("method::exit");
    }

    @SneakyThrows
    public static void sneaky() {
        throw new Exception();
    }

    public static <T extends Exception> void throwsUnchecked(Throwable toThrow) throws T {
        throw (T) toThrow;
    }
}
