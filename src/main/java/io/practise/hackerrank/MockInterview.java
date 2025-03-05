package io.practise.hackerrank;

public class MockInterview {
    public static void main(String[] args) {
        new Child();
    }
}

class Parent {
    static {
        System.out.println("Parent static block");
    }

    {
        System.out.println("Parent instance block");
    }
}

class Child extends Parent {
    static {
        System.out.println("Child static block");
    }

    {
        System.out.println("Child instance block");
    }
}


