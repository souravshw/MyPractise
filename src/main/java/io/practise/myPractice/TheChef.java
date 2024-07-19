package io.practise.myPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TheChef {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int testcase = Integer.parseInt(br.readLine());
		int result[] = new int[5];
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			ArrayList<array> ob = new ArrayList<array>();
			array temp;
			for (int j = 0; j < n; j++) {
				temp = new array(Integer.parseInt(br.readLine()), true);
				ob.add(temp);
			}
			// Now check the result
			result[i] = checkResult(ob);
			n = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < testcase; i++)
			System.out.println(result[i]);
	}

	static int checkResult(ArrayList<array> ob) {
		int result = 0;
		for (int i = 0; i < ob.size() - 1; i++) {
			array temp1, temp2;
			int x = ob.get(i).val;
			int y = ob.get(i + 1).val;

			if (x != y) {
				temp1 = ob.get(i);
				temp1.result = false;
				temp2 = ob.get(i + 1);
				temp2.result = false;
				ob.set(i, temp1);
				ob.set(i + 1, temp2);
			}
		}

		for (int j = 0; j < ob.size(); j++)
			if (ob.get(j).result == false)
				result++;

		return result;

	}
}

class array {
	int val;
	boolean result;

	public array(int val, boolean result) {
		this.val = val;
		this.result = result;
	}
}
