/*
Given a value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output :
For each testcase, in a new line, print the answer of each test case.

Constraints :
1 <= T <= 103
1 <= N <= 1012

Example:
Input :
3
6
10
30

Output :
1
2
3

Explanation:
Testcase 1: There is only one number 4 which has exactly three divisors 1, 2 and 4.
 */

package com.puzzles;

import java.util.Scanner;
import java.util.Vector;

class ThreeDivisors {
    static Vector<Long> primeArray = new Vector<Long>();
    static boolean primeNum[] = new boolean[1000000 + 1];

    static void sieveOfEratosthenes(int N) {
        primeNum[0] = false;
        primeNum[1] = false;
        for (int i = 2; i <= N; i++) {
            primeNum[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {

            if (primeNum[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    primeNum[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {

            if (primeNum[i]) {
                primeArray.add((long) i);
            }
        }
    }

    public static void main(String[] args) {
        sieveOfEratosthenes(1000000);

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();


            int count = 0;
            int index = 0;
            long currentNum = primeArray.get(index) * primeArray.get(index);

            while (currentNum <= n) {
                count++;
                index++;

                if (index == primeArray.size()) {
                    break;
                }

                currentNum = primeArray.get(index) * primeArray.get(index);
            }

            System.out.println(count);

        }
    }
}