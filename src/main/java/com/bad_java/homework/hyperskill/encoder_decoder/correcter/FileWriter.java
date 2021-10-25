package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWriter {

  public void writeTo(String output, String[] binaryBytes) throws IOException {
    OutputStream writer = new BufferedOutputStream(new FileOutputStream(output));
    for (String s : binaryBytes) {
      writer.write(Integer.parseInt(s, 2));
    }
    writer.flush();
  }
}
