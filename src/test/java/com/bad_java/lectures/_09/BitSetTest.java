package com.bad_java.lectures._09;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.Enumeration;

import static org.assertj.core.api.Assertions.assertThat;

public class BitSetTest {

    @Test
    void name() {
        BitSet bitSet = new BitSet(32);
        bitSet.set(10);
        bitSet.clear(10);
        bitSet.set(16);

        BitSet bitSet2 = new BitSet(32);
        bitSet2.or(bitSet);

        assertThat(bitSet2.get(16)).isTrue();

        bitSet.set(130);
    }
}
