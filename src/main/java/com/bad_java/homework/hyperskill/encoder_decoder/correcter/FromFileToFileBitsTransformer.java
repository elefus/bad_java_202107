package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;
import java.util.function.Function;

public class FromFileToFileBitsTransformer {

  public void apply(String input,
      Function<Byte, String> fun1,
      Function<StringBuilder, StringBuilder> fun2,
      String output) throws IOException {

    byte[] bytesOfText = new FileReader().readFrom(input);

    StringBuilder stringOfBits = new StringOfBitsReproducer().getStringOfBits(bytesOfText, fun1,
        fun2);

    String[] split = stringOfBits.toString().split("\\s+");
    new FileWriter().writeTo(output, split);
  }
}



