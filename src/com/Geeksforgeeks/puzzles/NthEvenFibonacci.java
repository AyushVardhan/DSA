/*
Given a positive integer N, find the Nth Even Fibonacci number. Since the answer can be very large, print the answer modulo 1000000007.

Input:

The first line of input contains T denoting the number of testcases.Then each of the T lines contains a single positive integer N.

Output:

Output the Nth Even Fibonacci number.

Constraints:

1<=T<=200
1<=N<=1000

Example:

Input:
3
1
2
5

Output:

2
8
610
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthEvenFibonacci {
    private static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long num = Long.parseLong(br.readLine());
            long nth = 2 + (num - 1) * 3;

            System.out.println(fibonacci(nth));
        }
    }

    private static long fibonacci(long n) {
        long a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % mod;
            a = b;
            b = sum;
        }
        return sum;
    }
}
