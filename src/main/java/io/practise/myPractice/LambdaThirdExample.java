package io.practise.myPractice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaThirdExample {

    public static void main(String[] args) {

        Function<Integer, Integer> myFunc = x -> x * 2;
        System.out.println(myFunc.apply(6));

        Function<Integer, String> f2 = num -> "value is " + num;
        f2.apply(50);

        Consumer<String> greeting = name -> System.out.println("Hello " + name);
        greeting.accept("Test");

        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        Predicate<Integer> isEven = num -> (num % 2) == 0;
        System.out.println(isEven.test(5));
    }
}
