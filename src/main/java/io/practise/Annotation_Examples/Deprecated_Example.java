package io.practise.Annotation_Examples;

class A {
  void m() {
    System.out.println("hello m");
  }

  @Deprecated
  void n() {
    System.out.println("hello n");
  }
}

class Deprecated_Example {
  public static void main(String args[]) {

    A a = new A();
    a.n();
  }
}
