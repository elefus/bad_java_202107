package com.bad_java.lectures._10;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesTest {

    @Test
    void name() {
        try (InputStream in = new FileInputStream("E:\\projects\\actual\\bad_java\\2021_07\\tmp\\black.txt")) {
            assertThat(in.available()).isEqualTo(6);
            assertThat(in.read()).isEqualTo(49);
            assertThat(in.read()).isEqualTo(50);
            assertThat(in.read()).isEqualTo(51);
            assertThat(in.read()).isEqualTo(52);
            assertThat(in.read()).isEqualTo(53);
            assertThat(in.read()).isEqualTo(54);
            assertThat(in.read()).isEqualTo(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void utf16() {
        try (InputStream in = new FileInputStream("E:\\projects\\actual\\bad_java\\2021_07\\tmp\\black_utf16.txt")) {
            assertThat(in.available()).isEqualTo(14);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void buffered() {
        String path = "E:\\projects\\actual\\bad_java\\2021_07\\tmp\\black.txt";
        try (InputStream in = new BufferedInputStream(new FileInputStream(path), 4)) {
            assertThat(in.available()).isEqualTo(6);
            assertThat(in.read()).isEqualTo(49);
            assertThat(in.read()).isEqualTo(50);
            assertThat(in.read()).isEqualTo(51);
            assertThat(in.read()).isEqualTo(52);
            assertThat(in.read()).isEqualTo(53);
            assertThat(in.read()).isEqualTo(54);
            assertThat(in.read()).isEqualTo(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void scanner() throws FileNotFoundException {
        String path = "E:\\projects\\actual\\bad_java\\2021_07\\tmp\\black.txt";
        FileInputStream input = new FileInputStream(path);
        Scanner scanner1 = new Scanner(input);
        Scanner scanner2 = new Scanner(input);
        System.out.println(scanner1.hasNext());
        System.out.println(scanner2.hasNext());
    }
}
