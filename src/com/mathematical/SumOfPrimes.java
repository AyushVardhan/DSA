/*
Given a positive integer N, calculate the sum of all prime numbers between 1 and N(inclusive).

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains one line of input containing N.

Output:
For each testcase, in a new line, print the sum of all prime numbers between 1 and N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
2
5
10
Output:
10
17
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfPrimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long N = Long.parseLong(br.readLine());
            getSumOfPrimes(N);
        }
    }

    private static void getSumOfPrimes(long n) {
        boolean[] prime = new boolean[(int) (n + 1)];
        Arrays.fill(prime, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]){
                long inc = 2;
                while (i * inc <= n) {
                    prime[(int) (i * inc)] = false;
                    inc++;
                }
            }
        }

        long sum = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
