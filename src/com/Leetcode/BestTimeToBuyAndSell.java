package com.Leetcode;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private static int maxProfit(int[] prices) {

        if (prices.length <= 0)
            return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;

    }

    private static int maxProfitWithSpace(int[] prices) {
        if (prices.length <= 0)
            return 0;

        int maxProfit = 0;
        int length = prices.length;
        int[] minLeft = new int[length];
        int[] maxRight = new int[length];

        minLeft[0] = prices[0];
        for (int i = 1; i < length; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], prices[i]);
        }

        maxRight[length - 1] = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxRight[i] - minLeft[i]);
        }

        return maxProfit;
    }
}
