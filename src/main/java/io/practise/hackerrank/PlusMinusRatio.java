package io.practise.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinusRatio {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();

    }

    private static void plusMinus(List<Integer> arr) {

        double countNegative = arr.stream().filter(element -> element < 0).count();

        double countPositive = arr.stream().filter(element -> element > 0).count();

        double countZero = arr.stream().filter(element -> element == 0).count();

        System.out.println(String.format("%.6f", (countPositive / arr.size())));

        System.out.println(String.format("%.6f", (countNegative / arr.size())));

        System.out.println(String.format("%.6f", (countZero / arr.size())));

    }
}
