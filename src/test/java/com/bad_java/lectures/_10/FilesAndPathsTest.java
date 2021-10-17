package com.bad_java.lectures._10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class FilesAndPathsTest {

    @Test
    void name() {
        File file = new File("data/black1.txt");
        boolean deleted = file.delete();
        System.out.println(deleted);

        Path path = Paths.get("data/black1.txt");
        assertThatCode(() -> Files.delete(path)).isExactlyInstanceOf(NoSuchFileException.class);
    }

    @Test
    void listDirectories() throws IOException {
        System.out.println(Arrays.toString(new File("/data/black.txt").list()));
        System.out.println(Arrays.toString(new File(".").listFiles()));

        Files.list(Paths.get("."))
             .filter(path -> path.toString().startsWith("."))
             .limit(2)
             .forEach(path -> System.out.println(path));
    }

    @Test
    void typesOfPaths() throws IOException {
        File file = new File("./src/main/../test/java");
        assertThat(file.exists()).isTrue();
        assertThat(file.isFile()).isFalse();
        assertThat(file.isDirectory()).isTrue();
        assertThat(file.isAbsolute()).isFalse();
        String sep = File.separator;
        assertThat(file.getCanonicalPath()).endsWith("src" + sep + "test" + sep + "java");

        Path relativePath = Paths.get("./src/main/../test/java");
        assertThat(relativePath.isAbsolute()).isFalse();
        assertThat(Files.exists(relativePath)).isTrue();
        assertThat(Files.isDirectory(relativePath)).isTrue();
        assertThat(Files.isSymbolicLink(relativePath)).isFalse();
        assertThat(Files.isRegularFile(relativePath)).isFalse();

        Path absolutePath = relativePath.toAbsolutePath();
        assertThat(absolutePath.getRoot()).startsWith(Paths.get("E:\\"));

        System.out.println(absolutePath.normalize());
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void getPermissions() throws IOException {
        Path path = Paths.get("data");

        // owner|group|other
        // rwxrwxrwx
        // 111101100
        // chmod 754 file.txt

        // chmod g+w
        // 111111100
        // 774

        // 111101000
        // chmod 750 file.txt

        // chown elefus

        Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
    }

    @Test
    void commonOperations() throws IOException {
        File file = new File(".");
        file.toPath();
        Path data = Paths.get("data");
        data.toFile();

        Path white = data.resolve("white.txt");
        assertThat(Files.exists(white)).isFalse();

        Files.createFile(white);
        assertThat(Files.exists(white)).isTrue();

        Files.delete(white);
        assertThat(Files.exists(white)).isFalse();

        assertThat(Files.isReadable(data)).isTrue();
        assertThat(Files.isWritable(data)).isTrue();
        assertThat(Files.isExecutable(data)).isTrue();
    }
}
