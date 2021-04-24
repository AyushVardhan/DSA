package com.Leetcode.slidingWindow;

public class CountWaysToReachNthStair {
    public static void main(String[] args) {
        System.out.println(countWays(4,3));
    }

    private static int countWays(int n, int m) {
        int MOD = (int) (Math.pow(10, 9) + 7);
        int res[] = new int[n+1];
        int tmp = 0;
        res[0] = 1;

        for (int i = 1; i <= n; i++){
            int s = i - m - 1;
            int e = i - 1;
            if (s >= 0) {
                tmp = (tmp - res[s]) % MOD;
            }

            tmp = (tmp + res[e]) % MOD;
            res[i] = tmp;
        }

        return res[n];
    }
}
