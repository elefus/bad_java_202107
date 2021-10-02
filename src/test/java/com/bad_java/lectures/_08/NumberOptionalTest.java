package com.bad_java.lectures._08;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

class NumberOptionalTest {

    @Test
    void name() {
        NumberOptional<MyNumber> ref = new NumberOptional<>(null);


    }
}

abstract class MyNumber extends Number implements Comparable<String>, Serializable, Cloneable {

}