package io.practise.dsa;

import java.util.Map;

public class RomanToInteger {

    // Optimized - O(n)
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i + 1 < s.length() && val < map.get(s.charAt(i + 1))) {
                sum -= val;
            } else {
                sum += val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger solver = new RomanToInteger();
        String roman = "LVIII"; // 58

        System.out.println("--- Roman to Integer Demonstration ---");
        System.out.println("Roman Numeral: " + roman);
        System.out.println("Converted Integer: " + solver.romanToInt(roman));
    }
}
