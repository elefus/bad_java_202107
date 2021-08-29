package com.bad_java.lectures._04;

public class InheritanceExample {

    public static void main(String[] args) {
        try {
            B b = new B();
            b.method();
        } catch (Exception e) {
            e.printStackTrace();
        }

        C c = new C();
        c.method();
    }
}

class B {

    public void method() throws Exception {

    }
}

class C extends B {

    @Override
    public void method() throws RuntimeException {

    }
}

class D extends C {

    @Override
    public void method() throws IllegalArgumentException, IllegalStateException {

    }
}

class E extends D {

    @Override
    public void method() {

    }
}
