/*
Given two numbers A and B. The task is to find the GCD of those 2 numbers.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two space separated integers A and B.

Output:
For each testcase, in a new line, print the GCD of the two numbers.

Constraints:
1 <= T <= 100
1 <= A, B <= 103

Example:
Input:
98 56
48 18

Output:
14
6
 */
package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int a, b = 0;
            if (N >= M) {
                a = N;
                b = M;
            } else {
                a = M;
                b = N;
            }

            int r = 0;
            while (a > b) {
                r = a % b;
                if(r==0){
                    break;
                }

                a = b;
                b = r;
            }

            System.out.println(b);
        }
    }
}
