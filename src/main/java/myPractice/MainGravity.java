package myPractice;
import java.io.IOException;
import java.util.Scanner;

public class MainGravity {

	static int gravity = 0;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String line = scan.next();
		int Test = Integer.parseInt(line);
		while (Test > 0) {
			String result = "No";
			char[] A = scan.next().toCharArray();
			char[] B = scan.next().toCharArray();
			if (A[A.length - 1] != '#' | B[B.length - 1] != '#')
				if (A[0] == '.' & B[0] == '#')
					result = checkPossibility(A, B);
				else if (B[0] == '.' & A[0] == '#')
					result = checkPossibility(B, A);
				else if (A[0] == '.' & B[0] == '.')
					result = bestPossibility(A, B);

			System.out.println(result);
			if (result.equals("Yes"))
				System.out.println(gravity);
			gravity = 0;
			Test--;
		}
	}

	static String checkPossibility(char[] A, char[] B) {
		int lane = 1;
		for (int i = 0; (i < A.length || i < B.length); i++) {
			if (A[i] == '.' && lane == 1)
				continue;
			else if (A[i] == '#' && lane == 1) {
				if (B[i] == '.' || B[i + 1] == '.') {
					gravity++;
					lane = 2;
				} else {
					return "No";
				}
			}
			if (B[i] == '.' && lane == 2)
				continue;
			else if (B[i] == '#' && lane == 2) {
				if (A[i] == '.' || A[i + 1] == '.') {
					gravity++;
					lane = 1;
				} else {
					return "No";
				}
			}
		}
		return "Yes";
	}

	static String bestPossibility(char[] A, char[] B) {
		int first = 0, second = 0;
		int lane = 1;
		int i;
		char[] C;
		for (i = 0; (i < A.length || i < B.length); i++) {
			if (A[i] == '.' && lane == 1)
				continue;
			else if (A[i] == '#' && lane == 1) {
				if (B[i] == '.' || B[i + 1] == '.') {
					first++;
					lane = 2;
				} else {
					return "No";
				}
			}
			if (B[i] == '.' && lane == 2)
				continue;
			else if (B[i] == '#' && lane == 2) {
				if (A[i] == '.' || A[i + 1] == '.') {
					first++;
					lane = 1;
				} else {
					return "No";
				}
			}
			if (i == (A.length - 1) & first != 0) {
				C = B;
				B = A;
				A = C;
				i = 0;
				second = first;
				first = 0;
			}
		}
		gravity = Math.min(first, second);

		return "Yes";
	}
}