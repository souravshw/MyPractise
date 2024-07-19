package InnerClass;

public class MemeberInnerClass {
	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		MemeberInnerClass obj = new MemeberInnerClass();
		Inner in = obj.new Inner();
		in.msg();
	}
}
