package com.bad_java.lectures._03;

import java.util.Objects;

public class ObjectExample extends Object {

  public static void main2(String[] args) {
    Holder holder1 = new Holder(42);
    Holder holder2 = new Holder(-1);
    Holder holder3 = new Holder(42);
    Holder holder4 = null;
    Holder holder5 = new Holder(42);
    Holder childHolder = new HolderChild(42);

    Object ref = holder2;

    System.out.println(holder1.equals(ref));

    Object obj = new Object();
    // reflexive -> true
    obj.equals(obj);

    // symmetric
    boolean symmetric = holder1.equals(holder3) && holder3.equals(holder1); // true

    // transitive
    boolean transitive = holder1.equals(holder3) && holder3.equals(holder5) && holder1.equals(holder5); // true

    // consistent
    boolean resultBefore = holder1.equals(holder3);
    // ...
    boolean resultAfter = holder1.equals(holder3);
    boolean consistent = resultBefore == resultAfter;

    // nullability
    holder1.equals(null); // -> false


//    System.out.println(holder1.equals(childHolder));

//
//    Object obj = holder1;
//
//    Class<?> class1 = obj.getClass();
//    Class<?> class2 = holder2.getClass();
//    System.out.println(class1);
//    System.out.println(class1 == class2);

//    System.out.println(holder1.equals(holder2));
//    System.out.println(holder1.equals(holder3));
//    System.out.println(holder1.equals(holder4));
//    System.out.println(holder1.equals("123"));
  }

  public static void main(String[] args) {
    Color color = new Color(0, 0, 0);
    TransparentColor black = new TransparentColor(0, 0, 0, 255);

    System.out.println(color.equals(black));
    System.out.println(black.equals(color));
  }
}

class TransparentColor extends Color {

  private int alpha;

  public TransparentColor(byte red, byte green, byte blue) {
    super(red, green, blue);
  }

  public TransparentColor(int red, int green, int blue, int alpha) {
    super(red, green, blue);
    this.alpha = alpha;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TransparentColor)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    TransparentColor that = (TransparentColor) o;
    return alpha == that.alpha;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), alpha);
  }
}




class Holder {

  private int field;

  public Holder(int field) {
    this.field = field;
  }

  public boolean equals(Holder other) {
    return this.field == other.field;
  }



//  @Override
//  public boolean equals(Object obj) {
//    if (obj == null) {
//      return false;
//    }
//    if (getClass() != obj.getClass()) {
//      return false;
//    }
//    return equals((Holder) obj);
//  }
}

class HolderChild extends Holder {

  public HolderChild(int field) {
    super(field);
  }
}