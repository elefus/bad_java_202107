package com.bad_java.homework.dnaParser;

import java.util.concurrent.TimeUnit;

public class ThreadsActivator {

  private int numberOfThreads;
  private int threadsBack;
  private int threadsToActivate;

  public void startThreads(Runnable run, int amount) {
    setUpActivator(amount);
    activateThreads(run);
  }

  private void setUpActivator(int amount) {
    this.threadsBack = 0;
    this.numberOfThreads = amount;
    threadsToActivate = amount;
  }

  private void activateThreads(Runnable run) {
    while (threadsToActivate > 0) {
      new Thread(startAndCaptureFinish(run)).start();
      --threadsToActivate;
    }

    while (isWait()) {
      waiting();
    }
  }

  private Runnable startAndCaptureFinish(Runnable run) {
    return () -> {
      run.run();
      threadsBack++;
    };
  }

  private boolean isWait() {
    return threadsBack < numberOfThreads;
  }

  private void waiting() {
    try {
      TimeUnit.MILLISECONDS.sleep(5);
    } catch (InterruptedException ignored) {

    }
  }

}
