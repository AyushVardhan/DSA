package com.challange.leetcode;

public class StoneGameVIII {
    public static void main(String[] args) {
        System.out.println(stoneGameVIII(new int[]{7,-6,5,10,5,-2,-6}));
    }

    private static int stoneGameVIII(int[] stones) {

        int maxSum = Integer.MIN_VALUE, idxMaxSum = 0;

        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
            if (sum > maxSum) {
                maxSum = sum;
                idxMaxSum = i;
            }
        }

        int aliceScore =  maxSum;
        int[] newScore = new int[stones.length - idxMaxSum];
        newScore[0] = maxSum;

        for (int i = 1; i < newScore.length; i++) {
            newScore[i] = stones[idxMaxSum + 1];
        }

        int bobScore = getMinLeft(newScore);
        int res = aliceScore - bobScore;
        return res;
    }

    private static int getMinLeft(int[] stones) {
        int minSum = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return sum;
    }

}
