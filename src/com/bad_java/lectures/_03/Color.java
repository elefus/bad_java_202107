package com.bad_java.lectures._03;

class Color implements Cloneable {

  private final byte red;
  private final byte green;
  private final byte blue; // int [4 bytes] [0|red|green|blue]

  public Color(byte red, byte green, byte blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public Color(int red, int green, int blue) {
    this((byte) red, (byte) green, (byte) blue);
  }

  public byte getRed() {
    return red;
  }

  public byte getGreen() {
    return green;
  }

  public byte getBlue() {
    return blue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Color)) {
      return false;
    }
    Color color = (Color) o;
    return red == color.red && green == color.green && blue == color.blue;
  }

  // int [4 bytes] [0|red|green|blue]
  @Override
  public int hashCode() {
    // 11111111 = -1
    // 00000000000000000000000011111111 = 255
    return (Byte.toUnsignedInt(red) << 16) | (Byte.toUnsignedInt(green) << 8) | Byte.toUnsignedInt(blue);
  }

  @Override
  public String toString() {
    return "Color{" +
        "red=" + red +
        ", green=" + green +
        ", blue=" + blue +
        '}';
  }

  @Override
  public Color clone() {
    try {
      Object clone = super.clone();
      return (Color) clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(e);
    }
  }
}
