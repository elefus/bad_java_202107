package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.io.IOException;

public class TaskHandler {

  private final Encoder encoder = new HammingCodeEncoder();
  private final Sender sender = new OneErrorPerByteSender();
  private final Decoder decoder = new HammingCodeDecoder();

  public void encodeFromTo(String input, String output) {
    try {
      encoder.encodeFromTo(input, output);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public void decodeFromTo(String input, String output) {
    try {
      decoder.decodeFromTo(input, output);
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public void sendFromTo(String input, String output) {
    try {
      sender.sendFromTo(input, output);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

