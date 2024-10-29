package io.practise;

class Serialisehasa {
  final int MAX_SIZE;// LINE 1

  Serialisehasa() {
    MAX_SIZE = 10;
    System.out.println(MAX_SIZE);
  }

  Serialisehasa(int a) {
    MAX_SIZE = a;// LINE 2
    System.out.println(MAX_SIZE);
  }

  public static void main(String[] args) {
    Serialisehasa f = new Serialisehasa();
    Serialisehasa f1 = new Serialisehasa(20);
    f1.finals();
  }

  void finals() {
    // MAX_SIZE=90;
    //MAX_SIZE++; Both don't work.
    System.out.println(MAX_SIZE);
  }
}