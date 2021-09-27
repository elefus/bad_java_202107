package tictactoe.io;

import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IOHandlerTest {

    IOHandler io = new IOHandler();
    final ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();

    @AfterEach
    void close() {
        io.close();
    }

    @CsvFileSource(resources = "IOHandleSendTest.csv", delimiter = ';')
    @ParameterizedTest
    void send(String expectedString) {
        io = new IOHandler(new ByteArrayInputStream(new byte[]{}), byteArrayOutput);

        io.send(expectedString);

        assertArrayEquals(String.format("%s%n", expectedString).getBytes(), byteArrayOutput.toByteArray());
    }

    @CsvFileSource(resources = "IOHandleReadNumberTest.csv", delimiter = ';')
    @ParameterizedTest
    void readNumber(int expectedNumber) {
        val numberAsBytes = Integer.toString(expectedNumber).getBytes();
        io = new IOHandler(new ByteArrayInputStream(numberAsBytes), byteArrayOutput);

        val actual = io.readNumber();

        assertEquals(expectedNumber, actual);
    }

    @CsvFileSource(resources = "IOHandleReadLineTest.csv", delimiter = ';')
    @ParameterizedTest
    void readLine(String expectedString) {
        io = new IOHandler(new ByteArrayInputStream(expectedString.getBytes()), byteArrayOutput);

        val actual = io.readLine();

        assertEquals(expectedString, actual);
    }

    @CsvFileSource(resources = "IOHandleReadWordTest.csv", delimiter = ';')
    @ParameterizedTest
    void readWord(String testString, String expectedWord, String secondExpectedWord) {
        io = new IOHandler(new ByteArrayInputStream(testString.getBytes()), byteArrayOutput);

        val actualWord = io.readWord();
        val actualSecondWord = io.readWord();

        assertEquals(expectedWord, actualWord);
        assertEquals(secondExpectedWord, actualSecondWord);
    }
}
