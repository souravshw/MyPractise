package myPractice;

public class InnerClassPractise implements NestedInterfaceClass.NestedInterface {
	/*
	 * Member Inner Class
	 */
	class MemberInner {
		void func() {
			System.out.println("from Member Inner Class");
		}
	}

	/*
	 * Static nested Class A static class i.e. created inside a class is called
	 * static nested class in java. It cannot access non-static data members and
	 * methods. It can be accessed by outer class name.
	 */
	static int data = 39;

	static class StaticNestedClass {
		static void func() {
			System.out.println(data + " from Static nested Class");
		}
	}

	// Member Function defining a local inner Class who is defining its own
	// function inside it.
	public void LocalInner() {
		/*
		 * Local Inner Class from local Inner method
		 */
		class LocalInnerClass {
			void func() {
				System.out.println("Local Inner Class from method");
			}
		}
		LocalInnerClass li = new LocalInnerClass();
		li.func();
	}

	public static void main(String[] args) {

		// Calling Anonymous Inner Class
		AnonymousInner ai = new AnonymousInner() {
			void eat() {
				System.out.println("from Main to Anonymous Inner class");
			}
		};
		ai.eat();

		// Calling Local Inner Class
		new InnerClassPractise().LocalInner();

		// Calling Member Inner Class
		InnerClassPractise ob = new InnerClassPractise();
		InnerClassPractise.MemberInner ob1 = ob.new MemberInner();
		ob1.func();

		// Calling Static Nested Class and Static method
		InnerClassPractise.StaticNestedClass snc = new InnerClassPractise.StaticNestedClass();
		snc.func();
		// or
		InnerClassPractise.StaticNestedClass.func();

		// Calling Nested Interface method mouse which is being overridden in PractiseInnerClass
		NestedInterfaceClass.NestedInterface ni = new InnerClassPractise();
		ni.mouse();
	}

	@Override
	public void mouse() {
		// TODO Auto-generated method stub
		System.out.print("Overridden mouse function in nested interface");
	}
}

/*
 * Anonymous Inner Class class that have no name is known as anonymous inner
 * class in java. It should be used if you have to override method of class or
 * interface.
 */
class AnonymousInner {
	void eat() {
		System.out.println("From Anonymous Inner class through class Definition");
	}
}

/*
 * Nested Interface is defined inside a class and it is being implemented by any
 * class by class name (.) inner interface name i.e
 * NestedInerfaceClass.NestedInterface
 */
class NestedInterfaceClass {
	interface NestedInterface {
		void mouse();
	}
}