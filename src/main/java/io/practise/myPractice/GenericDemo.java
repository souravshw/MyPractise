package io.practise.myPractice;

import java.util.ArrayList;

public class GenericDemo {

	static Person1 p1, p2, p3;
	static Stud s1, s2, s3;
	static Teacher1 t1, t2, t3;
	static Dog1 d1, d2, d3;

	public static void main(String[] args) {
		GenericDemo gd = new GenericDemo();
		gd.initialize();

		ArrayList<Person1> alP = new ArrayList<Person1>();
		alP.add(p1);
		alP.add(p2);
		alP.add(p3);
		int y = gd.Count(alP);
		System.out.println(y);

		ArrayList<Stud> tsS = new ArrayList<Stud>();
		tsS.add(s1);
		tsS.add(s2);
		tsS.add(s3);
		//System.out.println(gd.Count(tsS));

		ArrayList<Teacher1> alT = new ArrayList<Teacher1>();
		alT.add(t1);
		alT.add(t2);
		alT.add(t3);
		int u = gd.Count(alT);
		System.out.println(u);

		ArrayList<Dog1> alD = new ArrayList<Dog1>();
		alD.add(d1);
		alD.add(d2);
		alD.add(d3);
		// int p=gd.Count(alD);
		// It will give an error because class Dog1 does not extends class
		// Person

		GenericType<Integer, String> ob = new GenericType<Integer, String>(10, "Tendulkar");
		//System.out.println(ob.toString());
		System.out.println(gd.total(alT));
		System.out.println(gd.total(tsS));

	}

	// Generic Method Example
	@SuppressWarnings({ "unchecked", "hiding" })
	private <T> T Count(ArrayList<? super Teacher1> l) {
		return (T) new Integer(l.size());
	}

	private <T extends Person1>Object total(ArrayList<T> l) {
		Integer sum = 0;
		System.out.println(l);
		for (Person1 o : l) {
			sum += o.getAge();
		}
		return sum;
	}

	static void initialize() {
		p1 = new Person1("Jassi", 20, 45);
		p2 = new Person1("Jassi", 21, 45);
		p3 = new Person1("Jassi", 22, 45);
		s1 = new Stud("Jassi", 23, 45, 4);
		s2 = new Stud("Jassi", 24, 45, 9);
		s3 = new Stud("Jassi", 25, 45, 6);
		t1 = new Teacher1("Jassi", 26, 45, "Maths");
		t2 = new Teacher1("Jassi", 27, 45, "Bio");
		t3 = new Teacher1("Jassi", 28, 45, "English");
		d1 = new Dog1("Jassi", 23);
		d2 = new Dog1("Jassi", 23);
		d3 = new Dog1("Jassi", 23);
	}
}

class Dog1 {
	String name;
	int age;

	Dog1(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Dog1 [name=" + name + ", age=" + age + "]\n";
	}

}

class Person1 {
	String name;
	int age, pincode;

	Person1(String name, int age, int pincode) {
		this.name = name;
		this.age = age;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getPincode() {
		return pincode;
	}

	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + ", pincode=" + pincode + "]\n";
	}
}

class Stud extends Person1 {
	int standard;

	Stud(String name, int age, int pincode, int standard) {
		super(name, age, pincode);
		this.standard = standard;

	}

	public int getStandard() {
		return standard;
	}

	@Override
	public String toString() {
		return "Stud [name=" + name + ", age=" + age + ", pincode=" + pincode + ", standard=" + standard + "]\n";
	}
}

class Teacher1 extends Person1 {
	String subject;

	Teacher1(String name, int age, int pincode, String subject) {
		super(name, age, pincode);
		this.subject = subject;

	}

	public String getSubject() {
		return subject;
	}

	@Override
	public String toString() {
		return "Teacher1 [name=" + name + ", subject=" + subject + ", age=" + age + ", pincode=" + pincode + "]\n";
	}
}

// Generic Type Class
class GenericType<Person1, Dog> {
	private Person1 key;
	private Dog value;

	public GenericType(Person1 key, Dog value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "GenericType [key=" + key + ", value=" + value + "]";
	}
}