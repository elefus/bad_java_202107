package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.util.function.Function;

public class StringOfBitsReproducer {

  public StringBuilder getStringOfBits(byte[] bytes,
      Function<Byte, String> fun,
      Function<StringBuilder, StringBuilder> fun2) {

    StringBuilder builder = new StringBuilder();
    for (byte b : bytes) {
      builder.append(fun.apply(b));
    }

    builder = fun2.apply(builder);
    insertSpaces(builder);

    return builder;
  }

  private void insertSpaces(StringBuilder builder) {
    for (int i = 8; i < builder.length(); i += 9) {
      builder.insert(i, " ");
    }
  }
}



