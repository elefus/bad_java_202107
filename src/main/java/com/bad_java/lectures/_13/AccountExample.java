package com.bad_java.lectures._13;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Synchronized;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AccountExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(Account.class.getDeclaredFields()));

        Account account = new Account();

        Thread inc = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                account.inc();
            }
        });
        inc.start();

        Thread dec = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                account.dec();
            }
        });
        dec.start();

        System.out.println(dec.getState()); // !NEW
        System.out.println(dec.isAlive()); // true

        // starvation
        // blocking-set
        synchronized (account) {
            // dead-lock
            inc.join();
            dec.join();
        }

        System.out.println(account.getValue());
    }

    public static void main2(String[] args) throws InterruptedException {
        synchronized (Account.class) {
            Thread first = new Thread(() -> Account.method1());
            first.start();
            new Thread(() -> Account.method2()).start();

            first.join();
        }
    }
}

class Account {

    @Getter
    private volatile long value;
//    private final Object $lock = new Object();

    @Synchronized
    public void inc() {
//        synchronized ($lock) {
            ++value;
//        }
    }

    @Synchronized
    public void dec() {
//        synchronized ($lock) {
            --value;
//        }
    }

    @SneakyThrows
    public static synchronized void method1() {
        System.out.println("Called method1 by thread " + Thread.currentThread());
        TimeUnit.SECONDS.sleep(3);
    }

    @SneakyThrows
    public static void method2() {
        synchronized (Account.class) {
            System.out.println("Called method2 by thread " + Thread.currentThread());
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
