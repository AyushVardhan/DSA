package com.codemonk;

import java.util.*;


public class MinSteps {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int k = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();

            System.out.println(getCount(k, m, n));
        }
    }

    private static int getCount(int k, int m, int n) {
        if (k >= m) {
            // Sum of decrement by 1 i.e % and decrement by 2 i.e /
            return (k - m) % 2 + (k - m) / 2;
        }

        if (m % n == 0) {
            return 1 + getCount(k, m / n, n);
        } else {
            int x = (m / n + 1) * n;
            return (x - m) / 2 + (x - m) % 2 + getCount(k, x, n);
        }
    }
}
