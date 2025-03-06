package io.practise.accolite;

import java.util.Arrays;


public class MinMaxFromMultiDimentionalArray {

    public static void main(String[] args) {
        int[][] arr = {{1, 100},
                {50, 130}};

        Arrays.stream(arr).flatMapToInt(Arrays::stream).sorted();
    }


}

interface One {
    default String getName() {
        return "One";
    }
}

interface Two {
    default String getName() {
        return "Two";
    }
}
