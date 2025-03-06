package io.practise.accolite;

public class InheritanceChecker {
    public static void main(String[] args) {

        B b = new B();
        b.m1();
    }
}

class A {

    protected int x = 10;

    public void m1() {

        System.out.println("A m1()");

    }

    public void m2() {

        System.out.println("A m2()");

    }



}

class B extends A {

    public void m1() {

        System.out.println("B m1()");

    }
}


