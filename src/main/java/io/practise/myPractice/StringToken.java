package io.practise.myPractice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToken {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if (str.length() > 400000 || str.length() == 0) {
			System.out.println(0);
			System.exit(0);
		}
		str = str.trim();
		String delims = "[ !,?.\\_\'@]+";
		Pattern p =Pattern.compile(delims);
		Matcher m = p.matcher(str);
		System.out.println(m.toString());
		int n=0;
		while(m.find() && n < m.groupCount()){
			System.out.println(m.group(n));
			n++;
		}
	}
}
