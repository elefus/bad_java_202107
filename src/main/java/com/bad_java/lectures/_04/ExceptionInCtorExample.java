package com.bad_java.lectures._04;

public class ExceptionInCtorExample {

    public static void main(String[] args) {
        A a = null;
        try {
          a = new A();
        } catch (HackConstructorException ex) {
            A ref = ex.getRef();
            System.out.println("a = " + ref.getA());
            System.out.println("b = " + ref.getB());
        }
        System.out.println(a);
    }
}

class A {

    private int a;
    private int b;

    public A() {
        a = 1;
        if (true) {
            throw new HackConstructorException(this);
        }
        b = 2;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

class HackConstructorException extends RuntimeException {

    private A ref;

    public HackConstructorException(A ref) {
        this.ref = ref;
    }

    public A getRef() {
        return ref;
    }
}