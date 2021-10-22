package com.bad_java.lectures._13;

public class ConcurrentUpdatersExample {

    // x64
    // x86
    // long a = 123212132131233L

    // Atomicity
    public volatile static long counter;

    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        // Race condition
        Thread inc = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                // monitor

                synchronized (lock1) {  // critical section start
                    // read
                    // inc
                    // write
                    ++counter;
                }                  // critical section finish
            }
        });
        inc.start();

        Thread dec = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                synchronized (lock2) { // critical section
                    // read
                    // dec
                    // write
                    --counter;
                }                 // critical section finish
            }
        });
        dec.start();

        dec.join();
        inc.join();

        System.out.println(counter);
    }
}
