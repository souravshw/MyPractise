package myPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class DequeHack {

	public static void main(String[] args) {            
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
		}
		for (int i = 0; i <= n - m; i++) {
			Set<Integer> ss = new HashSet<Integer>();
			LinkedList<Integer> al = new LinkedList<Integer>();
			for (int j = i; j < i + m; j++) {
				al.add(deque.pop());
			}
			
			ss.addAll(al);
			if (max < ss.size())
				max = ss.size();
			
			al.removeFirst();
			deque.addAll(al);
			al.clear();
			ss.clear();
		}
		System.out.println(max);}
}