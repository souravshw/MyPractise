package Exception_Examples;

public class RunTimeExceptionPropagation {
	// By default RunTime Exceptions are propogated in calling chain
	void m() throws ArithmeticException {
		//int data = 50 / 0;
		throw new ArithmeticException();
	}

	void n() {
		m();
	}

	void p() {
	/*	try {
			n();
		} catch (ArithmeticException e) {
			System.out.println("exception handled");
		}*/
		n();
	}

	public static void main(String args[]){
		RunTimeExceptionPropagation obj = new RunTimeExceptionPropagation();
		obj.p();
		System.out.println("normal flow...");
	}
}
