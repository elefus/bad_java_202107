package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

public class Converter {

  public static String byteToString(byte b) {
    return String.format("%8s", Integer.toBinaryString(b)).replaceAll(" ", "0");
  }

}
