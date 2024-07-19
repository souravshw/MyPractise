package io.practise.InnerClass;

//A static class i.e. created inside a class is called static nested class in java.
// It cannot access non-static data members and methods. It can be accessed by outer class name.
class StaticNestedClass {
	static int data = 30;

	static class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		Inner obj = new Inner();
		obj.msg();

	}
}
