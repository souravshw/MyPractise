package io.practise.InnerClass;

public class MemeberInnerClass {
  private int data = 30;

  public static void main(String args[]) {
    MemeberInnerClass obj = new MemeberInnerClass();
    Inner in = obj.new Inner();
    in.msg();
  }

  class Inner {
    void msg() {
      System.out.println("data is " + data);
    }
  }
}
