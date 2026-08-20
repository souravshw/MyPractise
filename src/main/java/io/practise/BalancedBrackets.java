package io.practise;

public class BalancedBrackets {

    public static void main(String[] args) {
        String s="aabc";

        System.out.println(s.chars().mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst().get());
    }
}
