package io.practise.myPractice;

import java.util.*;
/**
public class ArrayListDemo {

  ArrayList<Student1> lt = new ArrayList<Student1>(30);
  LinkedList llt = new LinkedList();
  Vector vl = new Vector();

  public static void main(String[] args) {
    ArrayList ltq = new ArrayList(51);
    ltq.add(8);
    ltq.add("jjj");
    System.out.println(ltq);
    ArrayListDemo ob = new ArrayListDemo();
    System.out.println(ob.lt.size() + " " + ob.vl.capacity());
    // lt.addAll(3,vl);
    Iterator i = ob.llt.iterator();
    // System.out.println(vl.capacity());

    while (i.hasNext()) {
      if (i.next().equals(ob.lt.get(6)))
        System.out.println(true);
    }
    Enumeration en = ob.vl.elements();
    while (en.hasMoreElements()) {
      System.out.print(en.nextElement() + " ");
    }
    System.out.println(ob.vl.size() + " " + ob.vl.capacity());
  }

  public ArrayList getArrList() {
    return lt;
  }

  public void addList() {
    lt.add(new Student1("A", 6));
    lt.add(new Student1("B", 4));
    lt.add(new Student1("C", 3));
    lt.add(new Student1("D", 9));
    lt.add(new Student1("C", 9));
    lt.add(new Student1("B", 2));
    lt.add(new Student1("C", 3));

    vl.addAll(lt);
    vl.addAll(lt);
    vl.addAll(lt);
  }
}

class Student implements Comparable {
  String name;
  int roll;

  public Student(String name, int roll) {
    this.name = name;
    this.roll = roll;
  }

  public int getRoll() {
    return this.roll;
  }

  public String toString() {
    return name + " " + Integer.toString(roll);
  }

  public int compareTo(Object arg0) {
    if (this.roll > ((Student1) arg0).getRoll())
      return 1;
    else if (this.roll < ((Student1) arg0).getRoll())
      return -1;
    else
      return 0;
  }

}
 **/