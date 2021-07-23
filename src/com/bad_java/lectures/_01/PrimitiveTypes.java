package com.bad_java.lectures._01;

public class PrimitiveTypes {

    public static void main(String[] args) {
        // Primitive types - 8
            // Integer            //    SIZE                MIN_VALUE                MAX_VALUE                 DEFAULT_VALUE
            byte byteValue;       //   8 bits                 -128                     127                           0
            short shortValue;     //   16 bits                -32768                   32767                         0
            int intValue;         //   32 bits                -2147483648              2147483647                    0
            long longValue;       //   64 bits                -9223372036854775808     9223372036854775807           0L

            // Symbol
            char charValue;       //   16 bits    UTF-16       0                       65535                         0

            // Floating-point
            float floatValue;     //   32 bits                  1.4E-45                3.4028235e38                  0f
            double doubleValue;   //   64 bits                  4.9E-324               1.7976931348623157E308        0d

            // Logical
            boolean booleanValue; //   not specified           [false,true]                                         false

        // Binary format
        // прямой код
            // 0 = 0000 0000
            // 1 = higher > 0000 0001 < lower
            // 2 = 0000 0010
            // 3 = 0000 0011
            // 4 = 0000 0100

        // обратный код
            // -2 = 1111 1101

            //  5 = 0000 0101
            //  +
            // -7 = 1111 1000
            // -2 = 1111 1101
            //  2 = 0000 0010

            //  0 = 0000 0000
            // -0 = 1111 1111

        // дополнительный код
            //  5 = 0000 0101
            //      1111 1010 + 1
            // -5 = 1111 1011


            //  0 = 0000 0000
            //      1111 1111 + 1
            //  0 = 0000 0000

        // 1111 1111
        // 0000 0000
        // 0000 0001
        // result -1

        // 1000 0000
        // result -128

        int value = 7;
        System.out.println(~value + 1);

        // floating-point numbers
        // double - 15 десятичных чисел без потери точности
        // IEEE754
        // http://pages.cs.wisc.edu/~david/courses/cs552/S12/handouts/goldberg-floating-point.pdf

        // NaN
        double nan1 = Math.sqrt(-1);
        double nan2 = Math.sqrt(-1);

        double predefinedNan = Double.NaN;

        System.out.println(nan1);
        System.out.println(nan2);
        System.out.println(Double.isNaN(nan1));
        System.out.println(Double.isNaN(nan2));
        System.out.println(nan1 == Double.NaN);

        int nanInteger = (int) nan1;
        System.out.println(nanInteger);

        // Infinities
        double positiveInfinity = 1.0 / 0;
        System.out.println(positiveInfinity);
        double negativeInfinity = -1.0 / 0;
        System.out.println(negativeInfinity);
        double positiveOverflow = -Double.MAX_VALUE * 1000000;
        System.out.println(positiveOverflow);

        // Zeroes
        double positiveZero = +0.0;
        double negativeZero = -0.0;
        System.out.println(positiveZero == negativeZero);

        // Epsilon
        System.out.println(Math.ulp(1.0));

        // Literals
        // Integers
        int intValueLiteral = 153_002_323;
        int intValueLiteralOctal = 012;
        int intValueLiteralHex = 0x00AD_42BF;
        int intValueLiteralBinary = 0b1101_0101;
        // long longValueLiteral = 1023298392839l; codestyle violation
        long longValueLiteral = 1023298392839L;

        // decimal
        double doubleValueLiteral = 1.0;
        double doubleValueLiteralExp = 4.12343e10; // 4000000000
        System.out.println(doubleValueLiteralExp);
        float floatValueLiteral = 2.0f;

        // characters
        char charLiteral = '$';
        System.out.println(charLiteral);

        char charLiteralOct = '\341';
        System.out.println(charLiteralOct);

        char charLiteralHex = '\u3214';
        System.out.println(charLiteralHex);

        char quote = '\'';
        char doubleQuote = '"';
        char linefeed = '\n';
        char carriageReturn = '\r';
        char tab = '\t';
        char backslash = '\\';

        // Безобидный коммент \u000a System.out.println("Got you!");
        System.out.println(Character.toTitleCase('я'));
        System.out.println(Character.toUpperCase('я'));

        // Boolean
        // true
        // false

        // Reference types
        // all others types

        // null

        // void
    }
}
