package io.practise.InnerClass;

class A {
	interface Message {
		void msg();
	}
}

public class NestedInterfaceInClass implements A.Message {
	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String args[]) {
		A.Message message = new NestedInterfaceInClass();
		message.msg();
		NestedInterfaceInClass nic = new NestedInterfaceInClass();// upcasting here
		nic.msg();
	}
}