package io.practise.myPractice;

public class DuplicatesNumber {

    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 1, 3, 6, 4, 2, 3, 1};

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i] + " is repeated at index " + j);
                }
            }
        }
    }
}