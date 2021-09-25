package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

public class VarargsTest {

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    @Test
    void name() {
        Arguments res = Arguments.arguments(new char[] {'0', '1', '2'});
    }


}
