package io.practise.accolite;

public class TestSecondProblem {
    public static void main(String[] args) {

        int[] arr = {0, 1, 26, 8, 9, 2, 3, 27, 1, 0, 4};

        int count = 0;

        int maxCount = 0;

        for (int i = 0; i < arr.length; ++i) {
            int previous = arr[i];

            for (int j = i + 1; j < arr.length; ++j) {
                int diff = arr[j] - previous;

                if (diff == 1) {
                    ++count;
                    previous = arr[j];
                }
            }

            maxCount = Integer.max(maxCount, ++count);
            count = 0;
        }

        System.out.println(maxCount);


    }
}
