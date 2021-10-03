package com.bad_java.lectures._07;

public class StringExample {

    public static void main(String[] args) {
        // 568
        //

        // UTF-32
        // 00000000 00000000 00000010 00111000

        // UTF-16-LE / UTF-16-BE
        // Byte order mark
        // Little endian [FFFE] / Big endian [FEFF]
        // 00111000 00000010

        // UTF-8   1..4 bytes per symbol
        //
        System.out.println(Integer.toBinaryString(568));

        // U+0000 .. U+FFFF
        // U+10000 .. U+10FFFF
        // char[0] + char[1]
        // int
    }
}
