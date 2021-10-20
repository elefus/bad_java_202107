package com.bad_java.lectures._13;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ConcurrencyExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");

        Thread main = Thread.currentThread();

        // + new Thread().start()
        // + Executors
        // + ForkJoinPool
        // + Stream.parallel()
        // - CompletableFuture
        // - Reactive-programming

        Runnable task = () -> {
            System.out.println("Hello from child-thread: " + Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread childThread = new Thread(task);
        childThread.setName("Child-thread");
//        childThread.setPriority(10);
        // Thread affinity

        Thread.yield();

        childThread.start();


        System.out.println(main.getState());
        System.out.println(childThread.getState());

        TimeUnit.SECONDS.sleep(10);

        System.out.println(main);
        System.out.println(childThread);
    }
}

class CustomThread extends Thread {

    public CustomThread(String name) {
        super(name);
        start();
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Hello from child-thread: " + Thread.currentThread());
        TimeUnit.SECONDS.sleep(10);
    }
}