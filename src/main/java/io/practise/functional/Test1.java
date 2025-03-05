package io.practise.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
       /* List.of(11, 1, 2, 32, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .filter(num -> num == 10)
                .forEach(System.out::println);
                */

        int[] arrNum = {11, 1, 2, 32, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(arrNum).boxed().sorted(Comparator.reverseOrder())
                .limit(3).skip(2).forEach(System.out::println);
    }
}
