/*
Given a number N, check if a number is perfect or not. A number is said to be perfect if sum of all its factors excluding the number itself is equal to the number.

Input:
First line consists of T test cases. Then T test cases follow .Each test case consists of a number N.

Output:
For each testcase, in a new line, output in a single line 1 if a number is a perfect number else print 0.

Constraints:
1 <= T <= 300
1 <= N <= 1018

Example:
Input:
2
6
21
Output:
1
0
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long N = Long.parseLong(br.readLine());
            long sum = 0;

            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    long a = i;
                    long b = N / i;
                    if (b == N) {
                        sum = sum + a;
                        continue;
                    }
                    if (a == b) {
                        sum = sum + a;
                    } else {
                        sum = sum + a + b;
                    }
                }
            }

            System.out.println(sum==N ? 1 : 0);
        }
    }
}
