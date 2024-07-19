package io.practise.myPractice;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {

	public static void main(String[] args) throws IOException {
		Set<String> s = new HashSet<String>();
		Scanner br = new Scanner(System.in);
		int n = br.nextInt();
		for(int i=0; i<n; i++){
			String line=br.next()+" "+br.next();
			s.add(line.trim());
			System.out.println(s.size());
			}	
	}	
}