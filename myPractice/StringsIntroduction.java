package myPractice;

import java.io.*;
import java.util.*;

public class StringsIntroduction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		int length = A.length() + B.length();
		boolean r = true;
		int j = 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		
		if (A.length() < B.length()) {
			for (char c : a)
				if (c < b[j]) {
					r = false;
					break;
				} else if (c > b[j]) {
					r = true;
					break;
				}
			j++;
			if (j == A.length() && r == false)
				r = true;
		} else {
			for (char c : b) {
				if (c < a[j]) 
					{
						r = true;
						break;
					}
					if( c > a[j])
					{
						r= false;
						break;
					}
				}
				j++;
				if (j == B.length() && r == false)
					r = true;
			}
		
		if(A.equals(B))
			r=false;
		a[0] = Character.toUpperCase(a[0]);
		b[0] = Character.toUpperCase(b[0]);
		String str = String.valueOf(a) + " " + String.valueOf(b);
		if (r == false)
			System.out.println(length + "\n" + "No" + "\n" + str);
		else
			System.out.println(length + "\n" + "Yes" + "\n" + str);
	}
}