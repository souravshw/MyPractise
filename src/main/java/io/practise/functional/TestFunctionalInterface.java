package io.practise.functional;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class TestFunctionalInterface {

    @Test
    public void testMapComputeIfAbsent() {
        Map<String, String> names = new HashMap<>();

        names.put("1", "Sourav");
        names.put("2", "Vishal");

        assertEquals("SOURAV", names.computeIfAbsent("Sourav", val -> val.toUpperCase()));
    }

    @Test
    public void testEvenOddSeparationToMap() {
        Integer[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Map<Boolean, List<Integer>> integers = Stream.of(number).collect(Collectors.partitioningBy(num -> num % 2 == 0));

        assertEquals(2, integers.size());
    }

    @Test
    public void testEvenOddSeparationToList() {
        Integer[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Stream.of(number).collect(Collectors.collectingAndThen(Collectors.partitioningBy(num -> num % 2 == 0), Map::values)).forEach(System.out::println);
    }

    @Test
    public void testRemoveDuplicates() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10);

        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void testCharactersFrequency() {
        System.out.println(Arrays.stream("buiefjmrenjfiudjreuiofjk".split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    @Test
    public void testWordFrequency() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");

        System.out.println(names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    @Test
    public void testWordFrequencyAfterRemovingAName() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");

        System.out.println(names.stream().filter(name -> !name.equals("rohit")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    @Test
    public void testReversingSortedList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 120, 45, 89, 6, 7, 8, 9, 10);

        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    @Test
    public void testJoinListOfString() {
        List<String> strings = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");

        System.out.println(strings.stream().collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    public void multipleOf5() {
        List<Integer> numbers = Arrays.asList(10, 20, 33, 44, 55, 60, 77, 80, 90, 102, 103, 104, 105, 106, 107, 108, 109);

        System.out.println(numbers.stream().filter(n -> n % 5 == 0).collect(Collectors.toList()));
    }

    @Test
    public void minMaxFromList() {
        List<Integer> numbers = Arrays.asList(11, 60, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(numbers.stream().min(Comparator.naturalOrder()).get());
        System.out.println(numbers.stream().max(Comparator.naturalOrder()).get());

        System.out.println(numbers.stream().collect(Collectors.summarizingInt(Integer::intValue)));
    }

    @Test
    public void mergeUnsortedArraysToSortedWithoutDuplicates() {
        int[] firstArr = {11, 60, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] secondArr = {10, 20, 33, 44, 55, 60, 77, 80, 90, 102, 103, 104, 105, 106, 107, 108, 109};

        System.out.println(IntStream.concat(Arrays.stream(firstArr), Arrays.stream(secondArr))
                .boxed()
                .sorted()
                .distinct()
                .collect(Collectors.toList()));
    }

    @Test
    public void identifyDuplicatesNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7);

        list.stream().filter(eachNum -> list.indexOf(eachNum) != list.lastIndexOf(eachNum))
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void sumOf() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7);

        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }

    @Test
    public void testSecondLargestNumber() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7);

        list.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).forEach(System.out::println);
    }

    @Test
    public void testReversingAnArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7);

        IntStream.range(0, list.size()).map(num -> list.get(list.size() - num)).forEach(System.out::println);
    }

    @Test
    public void testListOfStringByIncreasingOrderOfLength() {
        List<String> strings = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");

        strings.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }).forEach(System.out::println);
    }

    @Test
    public void reverseEachWordInList() {

        Arrays.asList("My Name is Sourav Sanu Shaw".split(" "))
                .stream().map(eachWord -> new StringBuffer(eachWord).reverse())
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test
    public void findFirstNonRepeatingCharacters() {
        String word = "rohitrohi";

        Arrays.stream(word.split(""))
                .filter(letter -> word.indexOf(letter) == word.lastIndexOf(letter))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void findDuplicateCharacters() {
        String word = "rohitrohi";

        Arrays.stream (word.split (""))
                .filter (str -> word.indexOf (str) != word.lastIndexOf (str))
                .distinct()
                .collect (toList ()).forEach(System.out::print);
    }

    @Test
    public void generateFibonacciSeries() {
        Stream.iterate(new int[]{0,1},t->new int[]{ t[1], t[0]+ t[1] })
                .limit(20)
                .map(t->t[0])
                .forEach(System.out::println);
    }


}
