package com.bad_java.lectures._12;

public class InterfacesExample {

    public static void main(String[] args) {
        Impl ref = new Impl();
        ref.method2();

        BaseInterface.method();
    }

}

interface BaseInterface {

    static void method() {
        System.out.println("123");
    }

    static void main(String[] args) {
        System.out.println("Hello from interface");
    }

    default int method2() {
        return privateMethod();
    }

    private int privateMethod() {
        return 0;
    }
}

interface A extends BaseInterface {

    void method1();

    default int method2() {
        return 1;
    }
}

interface B {

    void method1();

    default int method2() {
        return 2;
    }
}

class Parent extends Object {

    int method2() {
        return 3;
    }
}

/**
 * 1. Классы всегда выигрывают
 * 2. Более специфичные интерфейсы имеют высший приоритет
 * 3. В случае неоднозначности - надо переопределить
 */
class Impl extends Parent implements A, B {

    @Override
    public void method1() {
        System.out.println("From method1");
    }

    @Override
    public int method2() {
        return super.method2() + A.super.method2() + B.super.method2();
    }
}