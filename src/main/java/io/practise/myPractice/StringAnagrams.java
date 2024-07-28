package io.practise.myPractice;

import java.util.HashMap;
import java.util.Scanner;

public class StringAnagrams {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    String B = sc.next();
    boolean ret = isAnagram(A, B);
    if (ret)
      System.out.println("Anagrams");
    else
      System.out.println("Not Anagrams");

  }

  static boolean isAnagram(String A, String B) {
    if (A.length() != B.length())
      return false;
    A = A.toLowerCase();
    B = B.toLowerCase();
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();

    HashMap<Character, Integer> s1 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> s2 = new HashMap<Character, Integer>();

    for (char t : a) {
      if (!s1.containsKey(t))
        s1.put(t, 1);
      else {
        int val = s1.get(t);
        s1.put(t, ++val);
      }
    }
    for (char t : b) {
      if (!s2.containsKey(t))
        s2.put(t, 1);
      else {
        int val = s2.get(t);
        s2.put(t, ++val);
      }
    }
    System.out.println(s1.size() + " " + s2.size());
    for (Character c : s1.keySet()) {
      if (!s2.containsKey(c))
        return false;
      else if (!s2.get(c).equals(s1.get(c)))
        return false;
    }
    return true;
  }
}
