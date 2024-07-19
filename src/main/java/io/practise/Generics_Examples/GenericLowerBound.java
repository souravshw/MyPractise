package io.practise.Generics_Examples;

import java.util.*;

public class GenericLowerBound {

	static int count =0;

	static void countitem(ArrayList<? super Teacher> l)
	{
		//only teacher and its super class will be acceptable
		for(Object o: l)
		{
			count++;
		}
		System.out.println("Items added : "+count);
		count=0;
	}

	public static void main(String args[])
	{
		Person p1 = new Person("Jassi",23,45);
		Person p2 = new Person("Jassi",23,45);
		Person p3 = new Person("Jassi",23,45);
		Student s1 = new Student("Jassi",23,45,4);
		Student s2 = new Student("Jassi",23,45,9);
		Student s3 = new Student("Jassi",23,45,6);
		Teacher t1 = new Teacher("Jassi",23,45,"Maths");
		Teacher t2 = new Teacher("Jassi",23,45,"Bio");
		Teacher t3 = new Teacher("Jassi",23,45,"English");
		Dog d1 = new Dog("Jassi",23);
		Dog d2 = new Dog("Jassi",23);
		Dog d3 = new Dog("Jassi",23);
		ArrayList<Person> ap= new ArrayList<Person>();
		ap.add(p1);
		ap.add(p2);
		ap.add(p3);
		ArrayList<Student> as= new ArrayList<Student>();
		as.add(s1);
		as.add(s2);
		as.add(s3);
		ArrayList<Teacher> at= new ArrayList<Teacher>();
		at.add(t1);
		at.add(t2);
		at.add(t3);
		ArrayList<Dog> ad= new ArrayList<Dog>();
		ad.add(d1);
		ad.add(d2);
		ad.add(d3);
		countitem(ap);
		//countitem(as);//will not work as Student is not superclass of Teacher 
		countitem(at);


	}

}

