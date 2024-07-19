package io.practise.myPractice;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.next();
			boolean result = true;
			char[] t = input.toCharArray();
			Stack s = new Stack();
			for (char c : t) {
				try {
					switch (c) {
					case '{':
						s.push('{');
						break;
					case '[':
						s.push('[');
						break;
					case '(':
						s.push('(');
						break;
					case '}':
						if (s.peek().equals('{'))
							s.pop();
						break;
					case ']':
						if (s.peek().equals('['))
							s.pop();
						break;
					case ')':
						if (s.peek().equals('('))
							s.pop();
						break;
					}
				} catch (EmptyStackException e) {
					s.push("A");
				}
			}
			if (s.isEmpty())
				System.out.println(true);
			else
				System.out.println(false);
		}
		System.exit(0);
	}
}
