package com.bad_java.lectures._13;

import java.util.concurrent.TimeUnit;

public class CounterExample {

    public static void main(String[] args) throws InterruptedException {
        Runnable counter = () -> {
            System.out.println("Counter started");
            long i = 0;
            Thread currentThread = Thread.currentThread();
            for (int count = 0; i < 10_000_000_000L; count++, i++) {
                if (count == 1_000_000) {
                    if (currentThread.isInterrupted()) {
                        break;
                    } else {
                        count = 0;
                    }
                }
            }
            System.out.println("Counter finished = " + i);
        };

        Thread thread = new Thread(counter);
        System.out.println("Main before thread.start()");
//        thread.setUncaughtExceptionHandler((t, e) -> {
//            System.out.println("Caught exception " + e + " from thread " + t);
//        });
        thread.start();

//        while (thread.isAlive()) { // spin-loop
//            TimeUnit.SECONDS.sleep(5);
//        }

//        System.out.println("Before join");
//        thread.join();
//        System.out.println("After join");

//        TimeUnit.SECONDS.sleep(2);
//        thread.stop();

        TimeUnit.SECONDS.sleep(3);

        thread.interrupt();
        thread.join();

        System.out.println("Main finished");
    }

}


