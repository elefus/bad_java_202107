package com.bad_java.lectures._13;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

public class ManagedCounterExample {

    public static void main(String[] args) throws InterruptedException {
        ManagedCounter counter = new ManagedCounter(10_000_000_000L);
        Thread worker = new Thread(counter, "Counter");
        worker.start();

//        worker.suspend(); // deprecated
        counter.suspend();

        TimeUnit.SECONDS.sleep(3);
//        worker.interrupt();
//        worker.resume(); // deprecated

        counter.stop();

        System.out.println("Main finished");
    }
}

@RequiredArgsConstructor
class ManagedCounter implements Runnable {

    // Visibility problem
    @Getter
    private volatile State state = State.NEW;
    private final long bound;
    private int current;

    @Override
    public void run() {
        state = State.RUNNING;

        loop: while (current < bound) {
            switch (state) {
                case RUNNING:
                    doWork();
                    break;

                case PAUSED:
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                case STOPPED:
                    break loop;

                default:
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Default = " + state);
            }
        }
        System.out.println("Counter finished, value = " + current);
    }

    private void doWork() {
        current++;
    }

    public void suspend() {
        state = State.PAUSED;
    }

    public void resume() {
        state = State.RUNNING;
    }

    public void stop() {
        state = State.STOPPED;
    }

    enum State {
        NEW,
        RUNNING,
        PAUSED,
        STOPPED
    }
}