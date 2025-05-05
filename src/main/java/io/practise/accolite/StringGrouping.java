package io.practise.accolite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * [apple, pineapple, appleinep, beetle, tlebee, beeetl, lapep, atyeti]
 * <p>
 * apple 2
 * pineapple 2
 * beetle 3
 * atyeti 1
 */
public class StringGrouping {

    public static void main(String[] args) {

        List<String> list = List.of("apple", "pineapple", "appleinep", "beetle", "tlebee", "beeetl", "lapep", "atyeti");

        Map<String, Integer> map = new HashMap<>();

        list.forEach(eachWord -> {

                    char[] arr = eachWord.toCharArray();

                    Arrays.sort(arr);

                    String finalValue = String.valueOf(arr);

                    if (!map.containsKey(finalValue)) {
                        map.put(finalValue, 1);
                    } else {
                        int count = map.get(finalValue);
                        map.put(finalValue, ++count);
                    }
                }
        );


        Map.Entry<String, Long> stringLongEntry = list.stream()
                .map(eachWord -> {
            char[] arr = eachWord.toCharArray();

            Arrays.sort(arr);

            return String.valueOf(arr);
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .findFirst()
                .get();


        System.out.println(stringLongEntry);

    }
}
