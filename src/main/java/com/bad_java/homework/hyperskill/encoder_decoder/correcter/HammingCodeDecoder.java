package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;

public class HammingCodeDecoder implements Decoder {

  public void decodeFromTo(String input, String output) throws IOException {
    new FromFileToFileBitsTransformer().apply(input, this::getDecodedSequence, a -> a, output);
  }

  private String getDecodedSequence(byte b) {
    String str = Converter.byteToString(b);
    str = str.substring(str.length() - 8);
    int counter = 0;

    if ((str.charAt(2) + str.charAt(4) + str.charAt(6)) % 2 != Integer.parseInt(
        String.valueOf(str.charAt(0)))) {
      counter += 1;
    }
    if ((str.charAt(2) + str.charAt(5) + str.charAt(6)) % 2 != Integer.parseInt(
        String.valueOf(str.charAt(1)))) {
      counter += 2;
    }
    if ((str.charAt(4) + str.charAt(5) + str.charAt(6)) % 2 != Integer.parseInt(
        String.valueOf(str.charAt(3)))) {
      counter += 4;
    }

    if (counter != 0) {
      char temp = str.charAt(counter - 1) == '0'
          ? '1'
          : '0';
      str = str.substring(0, counter - 1) + temp + str.substring(counter);
    }

    return str.charAt(2) + str.substring(4, 7);
  }
}
