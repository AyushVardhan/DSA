/*
Given a number N, the task is to find the largest prime factor of that number.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the largest prime factor of N.

Constraints:
1 <= T <= 100
2 <= N <= 1010

Example:
Input:
2
6
15
Output:
3
5
 */
package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class largestPrimeFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long N = Long.parseLong(br.readLine());
            getMaxPrimeFactor(N);
        }
    }

    private static void getMaxPrimeFactor(long n) {
        long maxPrime = -1;

        while (n % 2 == 0) {
            maxPrime = 2;
            n >>= 1;
        }

        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        if (n > 2) {
            maxPrime = n;
        }

        System.out.println(maxPrime);
    }
}
