package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;

public interface Sender {

  void sendFromTo(String input, String output) throws IOException;
}
