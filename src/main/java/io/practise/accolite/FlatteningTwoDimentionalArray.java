package io.practise.accolite;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatteningTwoDimentionalArray {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {-2, 0, 5, 7},
                {-3, 4, 6, 8, 9}};


        IntStream sorted = Stream.of(arr).flatMapToInt(Arrays::stream).sorted();

        sorted.forEach(eachElement -> System.out.println(eachElement));
    }
}
