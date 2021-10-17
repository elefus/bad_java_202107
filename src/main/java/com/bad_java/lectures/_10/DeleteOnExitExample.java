package com.bad_java.lectures._10;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteOnExitExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        File inputFile = File.createTempFile("bad_java_", "tmp");
        System.out.println(inputFile);
        inputFile.deleteOnExit();

        TimeUnit.SECONDS.sleep(10);

        if (true) {
            throw new IllegalArgumentException();
        }
    }
}
