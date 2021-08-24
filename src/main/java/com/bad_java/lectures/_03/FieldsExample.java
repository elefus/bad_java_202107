package com.bad_java.lectures._03;

/*
  Request [AAPL,100]             ->
                                <-  Response [AAPL, 50, locateID1]
                                <-  Response [AAPL, 50, locateID2]
  Cancel [AAPL, 50, locateID2]   ->
                                <-  Response [ACCEPTED/REJECTED]
 */
public class FieldsExample {

  public static final int TAG_ACCOUNT = 1;
  public static final int TAG_SIDE = 54;

  public static final String APP_VERSION = (String) System.getProperties().get("version");
  public static int publicStaticValue = 41;
  protected static int protectedStaticValue = 42;
  static int packageStaticValue = 43;
  private static int privateStaticValue = 44;
//  private static final Logger log = LoggerFinder.getLoggerFinder().getLogger("log", null);

  public int publicValue = 45;
  protected int protectedValue = 46;
  int packageValue = 47;
  private int privateValue;

  public static void main(String[] args) {
    // 1 [Account]
    // 54 [Side]

    System.out.println("Account = " + args[TAG_ACCOUNT]);
    System.out.println("Side = " + args[TAG_SIDE]);

    System.out.println(FieldsExample.privateStaticValue);
    System.out.println(FieldsExample.packageStaticValue);

    FieldsExample ref1 = new FieldsExample();
    FieldsExample ref2 = new FieldsExample();
    FieldsExample ref3 = ref1;

    System.out.println(ref1.privateValue); // 0

//    log.log(Level.ERROR, "this is error message");

    MethodsExample.helloFromMethodsExample();
    MethodsExample methodsExample = new MethodsExample();
    // methodsExample.helloFromMethodsExample(); // wrong, better to use ClassName.method();
  }

  /*
    [specifiers] type name [= initValue];

    specifiers:
      public
      protected
      package-visible
      private
      final
      static

      volatile
      transient
   */
}
