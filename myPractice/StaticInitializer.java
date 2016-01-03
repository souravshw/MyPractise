package myPractice;
import java.util.Scanner;
public class StaticInitializer {
	static boolean flag = false;
	static int B = (new Scanner(System.in)).nextInt();
	static int H = (new Scanner(System.in)).nextInt();
	static {
		try {
			if (B <= 0 || H <= 0) {
				throw new Exception("Breadth and height must be positive");
			}
            else
                flag=true;
		} catch (Exception e) {
			System.out.println(e);
			//System.exit(0);
		}
    }
	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}
}