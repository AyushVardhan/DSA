package com.Leetcode;

public class BestTimeToBuyAndSell2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    private static int maxProfit(int[] prices) {

        if (prices.length <= 0)
            return 0;

        int i = 0, totalProfit = 0;
        int buy, sell;

        while (i < prices.length) {
            buy = prices[i];
            while (i < prices.length - 1 && prices[i + 1] > prices[i]) {
                i++;
            }
            sell = prices[i];
            totalProfit += (sell - buy);
            i++;
        }

        return totalProfit;
    }
}
