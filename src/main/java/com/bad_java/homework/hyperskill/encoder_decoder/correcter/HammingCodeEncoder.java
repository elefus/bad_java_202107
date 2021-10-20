package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;

public class HammingCodeEncoder implements Encoder {

  public void encodeFromTo(String input, String output) throws IOException {
    new FromFileToFileBitsTransformer().apply(input, Converter::byteToString,
        this::getEncodedString, output);
  }

  private StringBuilder getEncodedString(StringBuilder builder) {
    StringBuilder encodedString = new StringBuilder();
    char temp = 'a';

    for (int i = 0; i < builder.length(); i += 4) {
      temp = (builder.charAt(i) + builder.charAt(i + 1) + builder.charAt(i + 3)) % 2 == 0
          ? '0'
          : '1';
      encodedString.append(temp);

      temp = (builder.charAt(i) + builder.charAt(i + 2) + builder.charAt(i + 3)) % 2 == 0
          ? '0'
          : '1';
      encodedString.append(temp);

      encodedString.append(builder.charAt(i));

      temp = (builder.charAt(i + 1) + builder.charAt(i + 2) + builder.charAt(i + 3)) % 2 == 0
          ? '0'
          : '1';
      encodedString.append(temp);

      encodedString.append(builder.subSequence(i + 1, i + 4));
      encodedString.append("0");
    }

    return encodedString;
  }

}
