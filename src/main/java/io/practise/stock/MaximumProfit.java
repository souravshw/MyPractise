package io.practise.stock;

public class MaximumProfit {

    public static void main(String[] args) {
        runExample(2, new int[]{3, 2, 6, 5, 0, 6, 1}, 10);
        runExample(2, new int[]{1, 4, 2, 7}, 8);
        runExample(1, new int[]{7, 6, 4, 3, 1}, 0);
    }

    public static int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        if (k >= n / 2) {
            return maxProfitWithUnlimitedTransactions(prices);
        }

        int[][] dp = new int[k + 1][n];

        for (int transaction = 1; transaction <= k; transaction++) {
            int maxDiff = -prices[0];

            for (int day = 1; day < n; day++) {
                dp[transaction][day] = Math.max(dp[transaction][day - 1], prices[day] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[transaction - 1][day] - prices[day]);
            }
        }

        return dp[k][n - 1];
    }

    private static int maxProfitWithUnlimitedTransactions(int[] prices) {
        int profit = 0;

        for (int day = 1; day < prices.length; day++) {
            if (prices[day] > prices[day - 1]) {
                profit += prices[day] - prices[day - 1];
            }
        }

        return profit;
    }

    private static void runExample(int k, int[] prices, int expected) {
        int actual = maxProfit(k, prices);
        System.out.println("k = " + k + ", profit = " + actual + ", expected = " + expected);
    }
}
