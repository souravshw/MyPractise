package myPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class HashMap_Java {

	public static void main(String[] args) throws IOException {
		int num = 0; String line="";
		
		InputStreamReader isr =new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (line = br.readLine();		 n>=1 && line!=null;		  line=(n==1)?sc.next():br.readLine(),n--) {
			num = Integer.parseInt(br.readLine());
			hm.put(line, num);
			//System.out.println(hm.toString());
			/*
			if(n==2){
				br.close();
			}*/
		}
		//System.out.println(line);
		while (sc.hasNext()) {
			if (hm.containsKey(line)) {
				System.out.println(line + "=" + hm.get(line));
			} else
				System.out.println("Not Found");
			line=sc.next();
		}
	}
}