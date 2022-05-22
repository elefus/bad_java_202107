package com.bad_java.lectures._09;

import com.bad_java.lectures._07.ConcatTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertiesTest {

    @Test
    void name() throws IOException {
        Properties props = new Properties();
        assertThat(props).isEmpty();

        props.load(ConcatTest.class.getResourceAsStream("messages.properties"));
        assertThat(props).isNotEmpty();
        assertThat(props.getProperty("input_username")).isEqualTo("default#1");
    }
}
