package com.bad_java.lectures._03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PathsExample {

  public static void main(String[] args) {
    try {
      Map<String, Path> mapping = new HashMap<>();

      Path path = Paths.get("E:\\projects\\actual\\bad_java\\2021_07\\tmp");
      Files.list(path).forEach(file -> mapping.put(file.getFileName().toString(), file));

      System.out.println(mapping);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
