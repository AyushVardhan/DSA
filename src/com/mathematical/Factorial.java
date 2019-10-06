/*
Given a positive integer N. The task is to calculate the factorial of N.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T testcases follow. In each test cases, it contains an integer 'N'.

Output:
For each testcase in a new line, print the factorial of N.

Constraints:
1 <= T <= 19
0 <= N <= 18

Example:
Input:
2
1
4

Output:
1
24

Explanation:
Testcase 2: Factorial of 4 is 4 * 3 * 2 * 1 = 24.
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            long n = Long.parseLong(br.readLine());
            long fac = 1; long tmp = n;

            while (tmp-- > 0){
                fac *= n--;
            }

            System.out.println(fac);
        }
    }
}
