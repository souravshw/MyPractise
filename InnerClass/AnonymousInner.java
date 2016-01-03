package InnerClass;
//class that have no name is known as anonymous inner class in java. It should be used if you have to override method of class or interface.
class Concrete {
	void eat() {
		System.out.println("Hello Motto");
	}

	void drink() {
		System.out.println("Drink pepsi Motto");
	}
}

class AnonymousInner {
	public static void main(String args[]) {
		Concrete p = new Concrete() {
			void eat() {
				System.out.println("nice fruits");
			}
		};
		p.eat();
		p.drink();
	}
}