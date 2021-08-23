package com.bad_java.lectures._03;

import java.util.concurrent.TimeUnit;

public class FinalizeExample {

  public static void main(String[] args) throws InterruptedException {
    FinalizableClass ref = new FinalizableClass(1);
    ref = null;

    new FinalizableClass(2);

    System.out.println("Before");
    System.gc();
    System.out.println("After");

    System.out.println("From main: " + Thread.currentThread());

//    long start = System.currentTimeMillis();
//    long a = Long.MIN_VALUE;
//    while (a != Long.MAX_VALUE) {
//      a++;
//    }
//    long finish = System.currentTimeMillis();
//    System.out.println((finish - start) / 1000);

    TimeUnit.SECONDS.sleep(10);

    System.out.println(FinalizableClass.zombie[0].id);
    System.out.println(FinalizableClass.zombie[1].id);
    System.out.println("Main thread finished");

  }

}

class FinalizableClass {

  static FinalizableClass[] zombie = new FinalizableClass[2];

  final int id;

  public FinalizableClass(int id) {
    this.id = id;
    System.out.println("Ctor of FinalizableClass");
  }

  @Override
  protected void finalize() {
    System.out.println("Finalize invoked: " + id);
    System.out.println("From finalize " + Thread.currentThread());

    zombie[id - 1] = this;
  }
}