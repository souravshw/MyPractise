package io.practise.Exception_Examples;

public class MulCatch {
  public static void main(String args[]) {
    try {
      int a[] = new int[5];
      a[1] = 30 / 0;  //Will throw Arithmetic Exception first if you divide by 0 Outof Bounds will come second
    } catch (ArithmeticException e) {
      System.out.println("task1 is completed : " + e);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("task 2 completed : " + e);
    } catch (Exception e) {
      System.out.println("common task completed");
    }

    System.out.println("rest of the code...");
  }
}
