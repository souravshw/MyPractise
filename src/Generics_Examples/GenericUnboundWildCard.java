package Generics_Examples;

import java.util.*;

public class GenericUnboundWildCard {
	static void addnum(ArrayList l) {
		System.out.println(l.size());
	}

	public static void main(String[] args) {
		ArrayList<Object> a1 = new ArrayList<Object>();
		a1.add(34);
		a1.add(89);
		a1.add(77);
		a1.add(new Integer(53));
		addnum(a1);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(34);
		a2.add(98);
		a2.add(77);
		a2.add(new Integer(53));
		addnum(a2);
		// TODO Auto-generated method stub
	}
}