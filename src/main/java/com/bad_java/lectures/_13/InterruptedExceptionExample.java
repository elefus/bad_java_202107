package com.bad_java.lectures._13;

import java.util.concurrent.TimeUnit;

public class InterruptedExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread child = new Thread(() -> {
            System.out.println("Child thread started");

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child thread finished");
        });
        child.start();

        TimeUnit.SECONDS.sleep(5);
        child.interrupt();
        child.join(3_000);
        System.out.println("Main finished = " + child.getState());
    }
}
