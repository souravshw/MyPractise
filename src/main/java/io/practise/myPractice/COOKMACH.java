package io.practise.myPractice;
import java.io.IOException;
import java.util.Scanner;

public class COOKMACH {

	static int operation = 0;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String line = scan.next();
		int Test = Integer.parseInt(line);
		while (Test > 0) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			checkChef(A, B);
			System.out.println(operation);
			operation = 0;
			Test--;
		}
	}

	static void checkChef(int A, int B) {
		while (A != 1 && B % A != 0) {
			if (A % 2 == 0) {
				A /= 2;
				operation++;
			} else {
				A = (A - 1) / 2;
				operation++;
			}
		}
		CheckMultiple(A, B);
	}

	static void CheckMultiple(int A, int B) {
		while (A != B) {
			A *= 2;
			operation++;
		}
	}

}
