package io.practise.string;

public class PermutationOfNumbers {
    public static void main(String[] args) {
        String str = "ABC";

        solve(str.toCharArray(), 0);
    }


    public static void swap(char[] arr, int index, int index2) {
        char temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }

    public static void solve(char[] arr, int index) {

        if (index == arr.length - 1) {
            System.out.print(String.valueOf(arr) + " ");
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            solve(arr, index + 1);
            swap(arr, index, i);
        }
    }
}
