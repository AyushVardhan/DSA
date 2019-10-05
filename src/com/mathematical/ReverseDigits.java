/*
Write a program to reverse digits of a number N.

Input:
The first line of input contains an integer T, denoting the number of test cases. T testcases follow. Each test case contains an integer N.

Output:
For each test case, print the reverse digits of number N .

Constraints:
1 ≤ T ≤ 104
1 ≤ N ≤ 1015

Example:
Input:
2
200
122
Output:
2
221
 */
package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0){
            long num = Long.parseLong(br.readLine());
            long tmp = num, rev = 0, rem = 0;

            while (tmp > 0){
                rem = tmp % 10;
                rev = rev*10 + rem;
                tmp = tmp / 10;
            }

            System.out.println(rev);
        }
    }
}
