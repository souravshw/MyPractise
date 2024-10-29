package io.practise.myPractice;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerClass {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigInteger b1 = new BigInteger(s.next());
        BigInteger b2 = new BigInteger(s.next());
        BigInteger ad = new BigInteger(b1.add(b2).toString());
        BigInteger mp = new BigInteger(b1.multiply(b2).toString());
        System.out.println(ad);
        System.out.println(mp);
    }
}
