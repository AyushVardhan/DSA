package com.divideConquer;

import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            System.out.println(fibonacci(n % 60) % 10);
        }
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int F[][] = new int[][]{{1, 1}, {1, 0}};
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        for (int i = 2; i <= n - 1; i++)
            multiply(F, M);

        return F[0][0];
    }

    private static void multiply(int[][] f, int[][] m) {
        int x = f[0][0] * m[0][0] + f[0][1] * m[1][0];
        int y = f[0][0] * m[0][1] + f[0][1] * m[1][1];
        int z = f[1][0] * m[0][0] + f[1][1] * m[1][0];
        int a = f[1][0] * m[0][1] + f[1][1] * m[1][1];
        f[0][0] = x % 60;
        f[0][1] = y % 60;
        f[1][0] = z % 60;
        f[1][1] = a % 60;
    }
}
