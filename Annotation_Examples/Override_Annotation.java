package Annotation_Examples;

//Java Annotation is a tag that represents the metadata i.e. attached with class, interface, methods or fields 
//to indicate some additional information which can be used by java compiler and JVM.
class Animal {
	void eatSomething() {
		System.out.println("eating something");
	}
}
//@Override annotation assures that the subclass method is overriding the parent class method.
//If it is not so, compile time error occurs.

///Sometimes, we does the silly mistake such as spelling mistakes etc. 
//So, it is better to mark @Override annotation that provides assurity that method is overridden.
class Dog extends Animal {
	@Override
	void eatSomething() {
		System.out.println("eating foods");
	}// should be eatSomething
}

class TestAnnotation1 {
	public static void main(String args[]) {
		Animal a = new Dog();
		a.eatSomething();
	}
}
