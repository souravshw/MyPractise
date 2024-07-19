package io.practise.myPractice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Setdemo {

	public static void main(String[] args) {
		LinkedHashSet<Student> st = new LinkedHashSet<Student>();

		HashSet hs = new HashSet(20);
		HashSet s = new HashSet();
		SortedSet ss = new TreeSet(new NewComparator());
		Iterator i;
		st.add(new Student("A", 6));
		st.add(new Student("B", 4));
		st.add(new Student("C", 3));
		st.add(new Student("D", 9));
		st.add(new Student("C", 9));
		st.add(new Student("B", 2));
		st.add(new Student("C", 3));

		s.add(2);
		s.add(4);
		s.add(5);
		s.add(12);
		s.add(2);
		s.add("Sanu");
		s.add("Sourav");
		s.add("Sanu");
		s.add("sourav");

		i = st.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		hs.addAll(st);
		hs.addAll(s);

		i = st.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

		System.out.println("\n" + s);
		System.out.println(hs);
		ss.addAll(st);

		System.out.println(ss);
	}
}

class NewComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		if (s1.getRoll() > s2.getRoll())
			return +1;
		else if (s1.getRoll() < s2.getRoll())
			return -1;
		else
			return 0;
	}
}