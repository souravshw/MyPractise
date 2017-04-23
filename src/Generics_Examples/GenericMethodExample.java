package Generics_Examples;

import java.util.*;

public class GenericMethodExample {
	static int sum = 0;

	static  <T> T docon(ArrayList<T> ob) {
		// this method will add and return the value of the list as an Integer
		// reference.
		for (T a : ob)

		{
			// System.out.println(a);
			sum += ((Integer) a).intValue();
		}
		return (T) new Integer(sum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(4);
		a1.add(5);
		a1.add(7);
		a1.add(3);
		int y= docon(a1);
		System.out.println("Sum of Arraylist Intger is " + y);

		docon(a1);
	}

}