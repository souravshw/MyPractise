package myPractice;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class ArrayListDemo {

	ArrayList<Student> lt = new ArrayList<Student>(30);
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
		lt.add(new Student("A", 6));
		lt.add(new Student("B", 4));
		lt.add(new Student("C", 3));
		lt.add(new Student("D", 9));
		lt.add(new Student("C", 9));
		lt.add(new Student("B", 2));
		lt.add(new Student("C", 3));

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

	@Override
	public int compareTo(Object arg0) {
		// System.out.println(this.toString()+" "+((Student)arg0).toString());
		if (this.roll > ((Student) arg0).getRoll())
			return 1;
		else if (this.roll < ((Student) arg0).getRoll())
			return -1;
		else
			return 0;
	}

}