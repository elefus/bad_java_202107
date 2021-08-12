package com.bad_java.lectures._03;

public class EnumsExample {

  public static void main(String[] args) {
    System.out.println(ResponseCode.SUCCESS.getClass());
    System.out.println(ResponseCode.SUCCESS.getCode());

    ResponseCode responseCode = ResponseCode.valueOf(0);
    System.out.println(responseCode);

//    {
//      Scanner in = new Scanner(System.in);
//      String input = in.nextLine();
//
//      Season season1 = Enum.valueOf(Season.class, "WINTER");
//      Season season = Season.valueOf(input.toUpperCase());
//
//      if (season == Season.WINTER) {
//        System.out.println("This is winter");
//      }
//
//      if (season.equals(Season.WINTER)) {
//        System.out.println("This is winter");
//      }
//
//      switch (season) {
//        case WINTER:
//          break;
//
//        case SPRING:
//          break;
//
//        case SUMMER:
//          break;
//
//        case AUTUMN:
//          break;
//
//      }
//    }
  }

  interface Successable {

    boolean isOk();
  }

  public enum ResponseCode implements Successable {
    SUCCESS(0) {
      @Override
      public String toString() {
        return "HELLO FROM SUCCESS" + super.toString();
      }

      @Override
      void method() {

      }

      @Override
      public boolean isOk() {
        return true;
      }
    },
    FAILED(1) {
      @Override
      void method() {

      }

      @Override
      public boolean isOk() {
        return false;
      }
    },
    EXPIRED(2) {
      @Override
      void method() {

      }

      @Override
      public boolean isOk() {
        return false;
      }
    },
    PARTIALLY_SUCCESS(3) {
      @Override
      void method() {

      }

      @Override
      public boolean isOk() {
        return true;
      }
    };

    private static final int STATIC = 100;

    static {

    }

    interface Successable {

      boolean isOk();

      class A {

      }
    }

    class A {

    }

    static class B {

    }

    private final int code;

    ResponseCode(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    @Override
    public String toString() {
      return "ResponseCode{" +
          "name=" + name() +
          ", code=" + code +
          '}' + super.toString();
    }

    abstract void method();

    public static ResponseCode valueOf(int code) {
      for (ResponseCode responseCode : values()) {
        if (responseCode.code == code) {
          return responseCode;
        }
      }
      return null;
    }

//    @Override
//    public boolean isOk() {
//      switch (this) {
//        case SUCCESS:
//        case PARTIALLY_SUCCESS:
//          return true;
//
//        default:
//          return false;
//      }
//    }
  }
}




enum Season {
  UNKNOWN,
  SPRING,
  WINTER,
  SUMMER,
  AUTUMN
}