package myPractice;

import java.io.*;

public class Datatypes {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int count = Integer.parseInt(reader.readLine());

		for (int i = 1; i <= count; i++) {
			try {
				line = reader.readLine();
				long n = Long.parseLong(line);
				if (n <= 127 && n >= -128) {
					System.out.println(n + " can be fitted in:");
					System.out.println("* byte");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n <= 32767 && n >= -32768) {
					System.out.println(n + " can be fitted in:");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n <= 2147483647 && n >= -2147483648) {
					System.out.println(n + " can be fitted in:");
					System.out.println("* int");
					System.out.println("* long");
				} else if (n <= (Math.pow(2, 63) - 1) && n >= Math.pow(-2, 63)) {
					System.out.println(n + " can be fitted in:");
					System.out.println("* long");
				} else
					System.out.println(" can't be fitted anywhere.");
			} catch (NumberFormatException e) {
				System.out.println(line + " can't be fitted anywhere.");
			}

		}
	}
}