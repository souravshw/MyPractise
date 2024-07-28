package io.practise.myPractice;

class tempGeneric {

  private static <T> void calc(T a, T b, T c) {
    if (a.equals(b) && b.equals(c))
      System.out.println("All of them are of same type");
    else
      System.out.println("Get Out");
  }

  public static void main(String[] args) {
    Integer a = new Integer(34);
    Double b = new Double(4.76);
    Float f = new Float(4.6f);
    calc(a, b, f);
  }
}