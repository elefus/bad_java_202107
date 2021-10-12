package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {

  public byte[] readFrom(String input) throws IOException {
    InputStream reader = new FileInputStream(input);
    return reader.readAllBytes();
  }
}


