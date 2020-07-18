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

    private static int maxProfitUtil(int[] prices, int k) {
        int T[][] = new int[k + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }

        printActualSolution(T,prices);
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

            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (T[i-1][k]-prices[k] == maxDiff){
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()){
            System.out.println("Buy at price : " + prices[stack.pollFirst()]);
            System.out.println("Sell at price : " + prices[stack.pollFirst()]);
        }
    }
}
