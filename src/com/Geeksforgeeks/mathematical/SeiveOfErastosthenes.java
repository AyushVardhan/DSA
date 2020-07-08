/*
Given a number N, calculate the prime numbers upto N using Sieve of Eratosthenes.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow. Each testcase contains one line of input containing N.

Output:
For all testcases, in a new line, print all the prime numbers upto or equal to N.

Constraints:
1 <= T<= 100
1 <= N <= 104

Example:
Input:
2
10
35
Output:
2 3 5 7
2 3 5 7 11 13 17 19 23 29 31
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeiveOfErastosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long N = Long.parseLong(br.readLine());
            getSievePrimes(N);
        }
    }

    private static void getSievePrimes(long n) {
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

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
