/*
Print all pairs (sets) of prime numbers (p,q) such that p*q <= n, where n is given number.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.
The first line of each test case is N.

Output:
For each testcase, in a new line, print the all pairs of prime numbers in increasing order.

Constraints:
1 ≤ T ≤ 50
4 ≤ N ≤ 400

Example:
Input:
2
4
8
Output:
2 2
2 2 2 3 3 2

Explanation:
Testcase 1: Pair (2, 2) which has both prime numbers as well as satisfying the condition 2*2 <= 4.
 */

package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PairsOfPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> primeList = new ArrayList<>();

            primeList.add(2);
            primeList.add(3);

            for (int i = 4; i <= N; i++) {
                if (isPrime(i)) {
                    primeList.add(i);
                }
            }

            for (int i = 0; i < primeList.size(); i++) {
                for (int j = 0; j < primeList.size(); j++) {
                    if (primeList.get(i) * primeList.get(j) <= N) {
                        System.out.print(primeList.get(i) + " " + primeList.get(j) + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
