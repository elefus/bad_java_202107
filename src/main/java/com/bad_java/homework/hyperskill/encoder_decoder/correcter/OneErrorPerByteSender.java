package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;
import java.util.Random;

public class OneErrorPerByteSender implements Sender {

  public void sendFromTo(String input, String output) throws IOException {
    new FromFileToFileBitsTransformer().apply(input, this::getByteWithError, a -> a, output);
  }

  private String getByteWithError(byte b) {
    b ^= 1 << new Random().nextInt(8);
    String temp = Converter.byteToString(b);
    return temp.substring(temp.length() - 8);
  }
}
