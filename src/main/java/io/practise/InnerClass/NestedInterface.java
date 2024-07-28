package io.practise.InnerClass;

interface Showable {
  void show();

  interface Message {
    void msg();
  }
}

class NestedInterface implements Showable.Message {
  public static void main(String args[]) {
    Showable.Message message = new NestedInterface();//upcasting here
    message.msg();
  }

  public void msg() {
    System.out.println("Hello nested interface");
  }
}