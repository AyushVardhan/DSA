/*
Given two numbers A and B, find Kth digit from right of AB.

Input:
The first line of the input contains T denoting the number of test cases. T testcases follow.  Each of the next T lines contains three space separated positive integers denoting the value of a , b and k respectively.

Output:
For each test case, in a new line, output the Kth digit from right of AB in new line.

Constraints:
1 <= T <= 100
1 <= A , B <=15
1 <= K <= |totaldigits in AB|

Example:
Input:
2
3 3 1
5 2 2
Output:
7
2
 */

package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintKthDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            long tmp = (long) Math.pow(A, B);
            long digit = 0;
            while (K > 0 && tmp > 0) {
                digit = tmp % 10;
                K = K - 1;
                tmp = tmp / 10;
            }
            System.out.println(digit);
        }
    }
}
