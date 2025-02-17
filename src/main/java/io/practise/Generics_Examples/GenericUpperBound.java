package io.practise.Generics_Examples;

import java.util.ArrayList;

public class GenericUpperBound {
  static int count = 0;

  static void countitem(ArrayList<? extends Person> l) {
    // only person and its subclasses will be acceptable not Dog
    for (Object o : l) {
      count++;
    }
    System.out.println("Items added : " + count);
    count = 0;
  }

  public static void main(String args[]) {
    Person p1 = new Person("Jassi", 23, 45);
    Person p2 = new Person("Jassi", 23, 45);
    Person p3 = new Person("Jassi", 23, 45);
    Student s1 = new Student("Jassi", 23, 45, 4);
    Student s2 = new Student("Jassi", 23, 45, 9);
    Student s3 = new Student("Jassi", 23, 45, 6);
    Teacher t1 = new Teacher("Jassi", 23, 45, "Maths");
    Teacher t2 = new Teacher("Jassi", 23, 45, "Bio");
    Teacher t3 = new Teacher("Jassi", 23, 45, "English");
    Sardar d1 = new Sardar("Jassi", 23);
    Sardar d2 = new Sardar("Jassi", 23);
    Sardar d3 = new Sardar("Jassi", 23);
    ArrayList<Person> ap = new ArrayList<Person>();
    ap.add(p1);
    ap.add(p2);
    ap.add(p3);
    ArrayList<Student> as = new ArrayList<Student>();
    as.add(s1);
    as.add(s2);
    as.add(s3);
    ArrayList<Teacher> at = new ArrayList<Teacher>();
    at.add(t1);
    at.add(t2);
    at.add(t3);
    ArrayList<Sardar> ad = new ArrayList<Sardar>();
    ad.add(d1);
    ad.add(d2);
    ad.add(d3);
    countitem(ap);
    countitem(as);
    countitem(at);
    //countitem(ad);

  }

}

class Sardar {
  String name;
  int age;

  Sardar(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

class Person {
  String name;
  int age, pincode;

  Person(String name, int age, int pincode) {
    this.name = name;
    this.age = age;
    this.pincode = pincode;

  }

}

class Student extends Person {

  String name;
  int age, pincode, standard;

  Student(String name, int age, int pincode, int standard) {
    super(name, age, pincode);
    this.standard = standard;

  }

}

class Teacher extends Person {

  String name, subject;
  int age, pincode;

  Teacher(String name, int age, int pincode, String subject) {
    super(name, age, pincode);
    this.subject = subject;

  }

}