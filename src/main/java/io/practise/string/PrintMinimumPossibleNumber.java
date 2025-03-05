package io.practise.string;

public class PrintMinimumPossibleNumber {
    public static void main(String[] args) {

        String num = "5012267075766";

        int[] arr = new int[9];

        char[] chars = num.toCharArray();

        for (char ch : chars) {
            arr[Integer.parseInt(String.valueOf(ch))]++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != 0) {
                for (int j = 1; j <= arr[i]; ++j) {
                    stringBuilder.append(i);
                }
            }
        }

        System.out.println(stringBuilder);
    }
}
