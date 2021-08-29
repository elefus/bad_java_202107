package com.bad_java.lectures._06;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class StringJoinerTest {

    StringJoiner joiner;

    @BeforeEach
    void setUp() {
        joiner = new StringJoiner();
    }

    @Test
    void noParamsProduceEmptyString() {
        // Act
        String result = joiner.join(",");

        // Assert
        assertEquals(result, "");
    }

    @MethodSource(value = "generator")
    @ParameterizedTest
    void oneParamHaveNoDelimiterAtResult(String param, String param2) {
        System.out.println(param2);

        // Act
        String result = joiner.join(",", param);

        // Assert
        assertEquals(result, param);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
            Arguments.arguments("a", "arg1"),
            Arguments.arguments("asdasd", "arg1"),
            Arguments.arguments("", "arg1")
        );
    }

//    @CsvSource(value = {"str1; str2; str1,str2", "a; b; a,b"}, delimiter = ';')
    @CsvFileSource(resources = "StringJoinerTest.csv", delimiter = ';')
    @ParameterizedTest
    void correctDelimiterBetweenTwoParams(String str1, String str2, String expectedResult) {
        // Act
        String result = joiner.join(",", str1, str2);

        // Assert
        assertEquals(result, expectedResult);
    }

    @Test
    void noDelimiterShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                joiner.join(null, "str1", "str2");
            }
        });

        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                joiner.join("", "str1", "str2");
            }
        });
    }
}