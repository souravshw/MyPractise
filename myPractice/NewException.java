package myPractice;
import java.util.logging.Logger;

public class NewException {

	public static void main(String[] args) {
		try {
			throw new worthy();
		} finally {
			System.out.println("Please Save Me\n");
		}
	}
}

class worthy extends RuntimeException {
	worthy() {
		super("Hello Exception");
	}
}