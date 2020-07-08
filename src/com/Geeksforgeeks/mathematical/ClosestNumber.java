/*
Given non-zero two integers N and M. The problem is to find the number closest to N and divisible by M. If there are more than one such number, then output the one having maximum absolute value.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow.  The first and only line of each test case contains two space separated integers N and M.

Output:
For each testcase, in a new line, print the closest number to N which is also divisible by M.

Constraints:
1 <= T <= 100
-1000 <= N, M <= 1000

Example:
Input:
2
13 4
-15 6
Output:
12
-18
 */

package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            if (N % M == 0) {
                System.out.println(N);
            } else {
                int rem = Math.abs(N) % Math.abs(M);
                int ans = 0;

                if(Math.abs(M) - rem <= rem){
                    ans = Math.abs(N) + Math.abs(M) -rem;
                }else {
                    ans = Math.abs(N) - rem;
                }

                if(N < 0){ans = ans * -1;}
                System.out.println(ans);
            }
        }
    }
}
