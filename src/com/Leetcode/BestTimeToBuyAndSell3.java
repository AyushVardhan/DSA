package com.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class BestTimeToBuyAndSell3 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }

    private static int maxProfit(int[] prices) {

        if (prices.length <= 0)
            return 0;

        return maxProfitUtil(prices, 2);
    }

    /*
    *
    * Above problem can be thought as, To find the maximum profit in doing at most k transactions, we need to know the maximum profit done
    * up to any day for an transaction.
    *
    * Lets say for one transaction, we got the maximum profit at day 3 and total days are 7, then up to day 7, the max profit for that day will
    * be what we calculated till day 3.
    *
    * Now to get max for two transaction, while looking for maxProfit with 2nd transaction at a day, we must know the max profit done with
    * 1 transaction before that day, then only we can accumulate the current one with previous maxProfit.
    *
    * So, let T[i][j] = It represents the maximum profit done by transaction count 'i', up to jth day.
    *                           _____________________
    *                           |
    *                           |  T[i][j-1], --> meaning we are not considering profit possible with current rate on day j
    *                    Max{   |  max( price[j] - price[m] + T[i-1][m] ), where m is between 0 to j-1th day
    *                           |
    *                           ______________________
    * */

    private static int maxProfitUtil(int[] prices, int k) {
        int T[][] = new int[k + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff); // Here maxDiff is referring to max from j-1 index
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]); //Calculating maxDiff for next day. So index [j] is utilised
            }
        }

        printActualSolution(T, prices);
        return T[k][prices.length - 1];
    }

    private static int maxProfitUtilSlow(int[] prices, int k) {
        int T[][] = new int[k + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i - 1][m]);
                }
                T[i][j] = Math.max(T[i][j - 1], maxVal);
            }
        }

        return T[k][prices.length - 1];
    }

    private static void printActualSolution(int T[][], int prices[]) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while (true) {
            if (i == 0 || j == 0)
                break;

            if (T[i][j] == T[i][j - 1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (T[i - 1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println("Buy at price : " + prices[stack.pollFirst()]);
            System.out.println("Sell at price : " + prices[stack.pollFirst()]);
        }
    }
}
