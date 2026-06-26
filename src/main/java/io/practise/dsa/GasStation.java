package io.practise.dsa;

import java.util.Arrays;

public class GasStation {

    // Greedy - O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        GasStation solver = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println("--- Gas Station Demonstration ---");
        System.out.println("Gas: " + Arrays.toString(gas));
        System.out.println("Cost: " + Arrays.toString(cost));
        System.out.println("Starting Index: " + solver.canCompleteCircuit(gas, cost));
    }
}
