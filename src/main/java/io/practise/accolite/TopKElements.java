package io.practise.accolite;

import java.util.Iterator;
import java.util.TreeSet;

public class TopKElements {

    public static void main(String[] args) {
        int[] arr = {1, 3, 66, 5, 7, 2, 3, 5, 9, 2, 11, 66, 75};

        int k = 3;

        TreeSet<Integer> treeSet = new TreeSet<>((o1, o2) -> {
            if (o2 > o1 || o2 == o1) {
                return 1;
            } else if (o2 < o1) {
                return -1;
            }

            return 1;
        });

        for (int a : arr) {
            treeSet.add(a);
        }

        Iterator<Integer> iterator = treeSet.iterator();

        while (iterator.hasNext() && k > 0) {
            Integer temp = iterator.next();
            System.out.println(temp);
            --k;
        }

    }
}
