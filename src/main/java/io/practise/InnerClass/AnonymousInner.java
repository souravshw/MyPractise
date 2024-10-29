package io.practise.InnerClass;
//class that have no name is known as anonymous inner class in java. It should be used if you have to override method of class or interface.

import java.util.logging.Level;
import java.util.logging.Logger;

interface Boy {

  void height() throws Exception;

  public default String getfly() {
    return "a";
  }
}

abstract class Concrete {

  abstract void eat();

  void drink() {
    System.out.println("Drink pepsi Motto");
  }
}

abstract class Concrete {

    abstract void eat();

    void drink() {
        System.out.println("Drink pepsi Motto");
    }
}

class AnonymousInner implements Boy {

  public static void main(String args[]) {
    Concrete p = new Concrete() {
      void eat() {
        System.out.println("Nice Fruits");
      }
    };
    p.eat();
    p.drink();

    Boy b = new Boy() {
      public void height() {
        System.out.println(Boy.class);
        System.out.println("I am Very tall.");
      }
    };

    try {
      b.height();
    } catch (Exception ex) {
      Logger.getLogger(AnonymousInner.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.println(b.getfly());
  }

  @Override
  public void height() throws Exception {
    System.out.println("I am Mad");
    try {
      throw new Exception();
    } catch (Exception e) {
      System.out.println("Hello");
    }
  }

  @Override
  public String getfly() {
    return Boy.super.getfly();
  }
}
