/*
Given two numbers A and B. The task is to find out their LCM and GCD.

Input:
The first line of input contains an integer T denoting the number of testcases. T testcases follow. In each test cases, there are two numbers A and B separated by space.

Output:
For each testcase in a new line, print LCM and GCD separated by space.

Constraints:
1 <= T <= 104
1 <= A <= 108
1 <= B <= 108

Example:
Input:
2
5 10
14 8

Output:
10 5
56 2

Explanation:
Testcase 1: LCM and GCD of given numbers 5 and 10 are: 10 and 5.
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCM_GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            String[] input = br.readLine().split(" ");
            long A = Long.parseLong(input[0]);
            long B = Long.parseLong(input[1]);

            long gcd = HCF(A,B);
            long lcm = (A * B)/gcd;
            System.out.println(lcm+" "+gcd);
        }
    }

    private static long HCF(long N, long M) {
        long a, b = 0;
        if (N >= M) {
            a = N;
            b = M;
        } else {
            a = M;
            b = N;
        }

        long r = 0;
        while (a > b) {
            r = a % b;
            if(r==0){
                break;
            }

            a = b;
            b = r;
        }
        return b;
    }
}
