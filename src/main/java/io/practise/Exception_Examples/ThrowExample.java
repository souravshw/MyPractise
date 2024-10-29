package io.practise.Exception_Examples;

public class ThrowExample {
  //throw throws an exception explicitly
  static void validate(int age) {
    if (age < 18)
      try {
        throw new ArithmeticException("not valid");
      } catch (ArithmeticException e) {
        System.out.println("Error is : " + e);

      }

    else
      System.out.println("welcome to vote");
  }

  public static void main(String args[]) {
    validate(13);
    System.out.println("rest of the code...");
  }
}
