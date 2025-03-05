package io.practise.myPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequentIPAddress {

    public static void main(String[] args) {
        List<String> ipList = Arrays.asList("10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20");

        ipList.stream().map(eachElement -> Arrays.stream(eachElement.split(" - ")).findFirst().get())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

    }
}

