package io.practise.myPractice;

interface MathOperation {
    int operation(int x);
}

public class LambdaExamples {

    public static void main(String[] args) {

        MathOperation increment = x -> x + 1;

        MathOperation multiplication = x -> x * 2 + 200;

        System.out.println(increment.operation(29));

        System.out.println(multiplication.operation(30));
    }
}
