package io.practise.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class TopKElementsInTheArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 56, 23, 43, 21, 45, 64};

        int k = 5;

        TreeSet<Integer> treeSet = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));

        Arrays.stream(arr).forEach(treeSet::add);

        List<Integer> arrayList = new ArrayList<>();

        IntStream.range(0, k).forEach(num -> arrayList.add(treeSet.pollFirst()));

        System.out.println(arrayList);
    }
}
