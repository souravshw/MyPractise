package io.practise.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture first = CompletableFuture.supplyAsync(FirstThread::new);

        CompletableFuture second = CompletableFuture.supplyAsync(SecondThread::new);

        CompletableFuture<Void> voidCompletableFuture = first.thenCombine(second, (o, o2) -> {
            return o.toString() + " " + o2.toString();
        });

        System.out.println(voidCompletableFuture.get());
    }
}

class FirstThread implements Callable<String> {
    private static int count = 0;

    @Override
    public String call() {
        return Integer.toString(count += 2);
    }

    @Override
    public String toString() {
        return "FirstThread{}";
    }
}

class SecondThread implements Callable<String>  {
    private static int count = 1;

    @Override
    public String call() {
        return Integer.toString(count+=3);
    }

    @Override
    public String toString() {
        return "SecondThread{}";
    }
}
