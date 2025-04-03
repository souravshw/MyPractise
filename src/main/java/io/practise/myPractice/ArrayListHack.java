package io.practise.myPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int limit = 0;

        ArrayList<ArrayList<Integer>> al = new ArrayList<>(n);

        while (limit < n) {

            int s = sc.nextInt();

            ArrayList<Integer> temp = new ArrayList<Integer>(s);

            while (s > 0) {
                temp.add(sc.nextInt());
                s--;
            }
            al.add(temp);
            limit++;
        }

        int nq = sc.nextInt();

        while (nq > 0) {
            int row, col;

            row = sc.nextInt();

            col = sc.nextInt();

            if (al.get(row - 1).size() < col) {
                System.out.println("ERROR!");
            } else {
                System.out.println(al.get(row - 1).get(col - 1));
            }
            nq--;
        }
    }
}