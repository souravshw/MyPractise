package Exception_Examples;

public class FinalExample {
	public static void main(String args[]) {
		try {
			int data = 25 / 0;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.exit(0);
		} finally {// This block of code is always executed
			System.out.println("finally block is always executed");
		}
		System.out.println("rest of the code...");
	}
}
