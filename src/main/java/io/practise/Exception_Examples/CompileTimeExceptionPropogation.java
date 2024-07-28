package io.practise.Exception_Examples;

import java.io.IOException;

public class CompileTimeExceptionPropogation {
  public static void main(String args[]) {
    CompileTimeExceptionPropogation obj = new CompileTimeExceptionPropogation();
    obj.p();
    System.out.println("normal flow");
  }

  // Rule: By default, Checked Exceptions are not forwarded in calling chain
  // (propagated).
  // and must be handled or declared
  void m() throws IOException {
    throw new IOException("device error");// checked exception
  }

  void n() {
    try {
      m();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  void p() {
    try {
      n();
    } catch (Exception e) {
      System.out.println("exception handeled");
    }
  }
}
