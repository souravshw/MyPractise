package io.practise.accolite;

import java.util.*;

public class CalculateMinPossibleTime {

    public static int calculateMinTime(HashMap<String, Integer> personTimeMap) {

        List<Map.Entry<String, Integer>> people = new ArrayList<>(personTimeMap.entrySet());

        people.sort(Map.Entry.comparingByValue());

        int n = people.size();

        int totalTime = 0;

        while (n > 3) {
            int firstPersonTimer = people.get(0).getValue();

            int secondPersonTimer = people.get(1).getValue();

            int timeN = people.get(n - 1).getValue();

            int timeNMinus1 = people.get(n - 2).getValue();

            totalTime += Math.min(2 * secondPersonTimer + timeN + firstPersonTimer, 2 * firstPersonTimer + timeN + timeNMinus1);

            n -= 2;
        }

        if (n == 3) {
            totalTime += people.get(0).getValue() + people.get(1).getValue() + people.get(2).getValue();
        } else if (n == 2) {
            totalTime += people.get(1).getValue();
        } else if (n == 1) {
            totalTime += people.get(0).getValue();
        }

        return totalTime;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> personTimeMap = new HashMap<>();

        personTimeMap.put("A", 1);
        personTimeMap.put("B", 3);
        personTimeMap.put("G", 48);
        personTimeMap.put("E", 50);
        personTimeMap.put("F", 75);
        personTimeMap.put("C", 200);
        personTimeMap.put("D", 150);

        int minTime = calculateMinTime(personTimeMap);

        System.out.println("Minimum time to cross the bridge: " + minTime);
    }
}