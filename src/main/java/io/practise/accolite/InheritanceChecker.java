package io.practise.accolite;

public class InheritanceChecker {
    public static void main(String[] args) {

        A b = new B();
        b.m1();
    }
}

class A {

    protected int x = 10;

    public void m1() {

        System.out.println("A m1()");

    }

}

class B extends A {

    public void m1() {

        System.out.println("B m1()");

    }
}


