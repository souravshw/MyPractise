package io.practise.leetcode.medium;

//    Write a program to sort the list based on the max occurrences
//     List<Integer> list = Arrays.asList(2,3,2,2,5,5,6,5,7,5,3,1);

//     input : {2,3,2,2,5,5,6,5,7,5,3,1}
//     output: {5,5,5,5,2,2,2,3,3,6,7,1}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortBasedOnOccurance {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 3, 2, 2, 5, 5, 6, 5, 7, 5, 3, 1);

        //System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        List<Integer> output = new ArrayList<>();

        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList())
                .forEach(integerLongEntry -> {
                    for (int index = 0; index < integerLongEntry.getValue(); ++index) {
                        output.add(integerLongEntry.getKey());
                    }
                });

        System.out.println(output);
    }
}
