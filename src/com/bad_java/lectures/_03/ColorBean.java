package com.bad_java.lectures._03;

import java.io.Serializable;

// Bean
// Spring Bean
// EJB - Enterprise Java Bean
class ColorBean implements Serializable {

  private byte red;
  private byte green;
  private byte blue;
  private boolean isBlack;

  public ColorBean() {
    this(0, 0, 0);
  }

  public ColorBean(byte red, byte green, byte blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public ColorBean(int red, int green, int blue) {
    this((byte) red, (byte) green, (byte) blue);
  }

  public boolean isBlack() {
    return isBlack;
  }

  public void setBlack(boolean black) {
    isBlack = black;
  }

  public void setRed(byte red) {
    this.red = red;
  }

  public void setGreen(byte green) {
    this.green = green;
  }

  public void setBlue(byte blue) {
    this.blue = blue;
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
    if (!(o instanceof ColorBean)) {
      return false;
    }
    ColorBean color = (ColorBean) o;
    return red == color.red && green == color.green && blue == color.blue;
  }

  @Override
  public int hashCode() {
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
}
