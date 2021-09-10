package com.bad_java.lectures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class CustomOptionalTest {

    @Test
    void createObject() {
        String str = "String value";

        CustomOptional<String> optional = new CustomOptional<>(str);
        assertThat(optional.get()).isSameAs(str);
        assertThat(optional.isEmpty()).isFalse();
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional).hasToString("Optional[String value]");

        if ((optional instanceof CustomOptional)) {
            fail("Optional is not an instance of CustomOptional");
        }
    }
}