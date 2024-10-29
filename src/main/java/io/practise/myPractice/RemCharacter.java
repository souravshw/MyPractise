package io.practise.myPractice;

public class RemCharacter {

  public static void main(String[] args) {

    String str = "I am a good Boy.";
    char rem = 'd';

    int loc = str.indexOf(rem);

    str = str.substring(0, loc).concat(str.substring(loc + 1));
    System.out.println(str);
  }

}
