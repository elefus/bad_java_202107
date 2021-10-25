package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;

public interface Decoder {

  void decodeFromTo(String input, String output) throws IOException;
}
