package io.practise.accolite;

public class StockBuyAndSellMaxProfitChecker {
    public static void main(String[] args) {
        int arr[] = {100, 180, 260, 310, 40, 535, 695};

        int arr1[] = {4, 2, 2, 2, 4};

        System.out.println(getMaxProfit(arr1));

        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] arr) {
        int profit = 0;

        for (int i = 1; i < arr.length; ++i) {

            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }

        return profit;
    }
}
