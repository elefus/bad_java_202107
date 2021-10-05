package com.bad_java.lectures._10;

import com.bad_java.lectures._09.ArrayDequeTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

    @Test
    void relativePath() {
        try (InputStream in = new FileInputStream("data/black.txt")) {
            assertThat(in.available()).isEqualTo(6);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    void resourcesPath() {
        try (InputStream in = FilesTest.class.getResourceAsStream("./../_09/another_package_file.txt")) {
            assertThat(in.read()).isEqualTo(66);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = ArrayDequeTest.class.getResourceAsStream("another_package_file.txt")) {
            assertThat(in.read()).isEqualTo(66);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void randomAccessFile() {
        try (RandomAccessFile in = new RandomAccessFile("data/black.txt", "r")) {
            in.seek(3);
            assertThat(in.read()).isEqualTo(52);

            in.seek(0);
            assertThat(in.read()).isEqualTo(49);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void inputStreamReader() {
        try (FileReader reader = new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16BE)) {
            assertThat(reader.read()).isEqualTo(0xFEFF);
            assertThat((char)reader.read()).isEqualTo('T');
            assertThat((char)reader.read()).isEqualTo('e');
            assertThat((char)reader.read()).isEqualTo('x');
            assertThat((char)reader.read()).isEqualTo('t');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16)) {
            assertThat((char)reader.read()).isEqualTo('T');
            assertThat((char)reader.read()).isEqualTo('e');
            assertThat((char)reader.read()).isEqualTo('x');
            assertThat((char)reader.read()).isEqualTo('t');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = FilesTest.class.getResourceAsStream("/top_level_resource.txt");
             Reader reader = new InputStreamReader(in, StandardCharsets.UTF_16);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            assertThat((char)bufferedReader.read()).isEqualTo('T');
            assertThat((char)bufferedReader.read()).isEqualTo('e');
            assertThat((char)bufferedReader.read()).isEqualTo('x');
            assertThat((char)bufferedReader.read()).isEqualTo('t');

            assertThat(bufferedReader.readLine()).isEqualTo(" from top level resource");
            assertThat(bufferedReader.readLine()).isEqualTo("Next line");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readAllLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16))) {
            for (String curr = reader.readLine(); curr != null; curr = reader.readLine()) {
                System.out.println(curr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
