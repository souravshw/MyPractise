package io.practise.myPractice;

import java.time.LocalDateTime;

@FunctionalInterface
interface SecondTask {
    void test();
}

@FunctionalInterface
interface ThirdTask {
    int reTest(int a, int b);
}

interface Task {
    void run();

    default int foo() {
        System.out.println("in default method");
        return 1;
    }
}


public class LambdaSecondExample {
    public static void runner(Task task) {
        System.out.println("start :" + LocalDateTime.now());
        task.run();
        task.foo();
        System.out.println("end :" + LocalDateTime.now());
    }

    public static void main(String[] args) {

        Task task = () -> System.out.println("Hello World");
        task.run();

        LambdaSecondExample.runner(() -> System.out.println("Test Me"));

        SecondTask secondTask = () -> System.out.println("Second Task");
        secondTask.test();

        ThirdTask thirdTask = ((a,b) -> {
            return a + b;
        });

        System.out.println(thirdTask.reTest(1, 2));
    }
}