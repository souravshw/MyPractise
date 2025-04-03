package io.practise.accolite;

public class SummingUpToN {
    public static void main(String[] args) {
        int[] firstArr = {8, 2, 6, 4, 13, 10};

        int[] secondArr = {2, 8, 13, 5, 9, 4, 9, 9, 9, 5};

        int target = 10;

        int count = 0;

        int length = Integer.max(firstArr.length, secondArr.length);

        for (int index = 0; index < length; ++index) {

            if (getNumber(firstArr, index) + getNumber(secondArr, index) == target) {
                ++count;
            }

        }

        System.out.println(count);

    }

    static int getNumber(int[] firstArr, int index) {
        try {
            return firstArr[index];
        } catch (Exception e) {
            return 0;
        }
    }
}
