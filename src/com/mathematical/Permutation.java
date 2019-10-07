/*
Write a program to calculate nPr. nPr represents n permutation r and value of nPr is (n!) / (n-r)!.

Input:
The first line of the input contains T denoting the number of testcases. T testcases follow. First line of the test case will be the value of n and r respectively.

Output:
For each test case, in a new line, output will be the value of nPr.

Constraints:
1 <= T <= 100
1 <= n,r <= 20
n >= r

Example:
Input:
2
2 1
10 4
Output:
2
5040
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);

            int div = N - R;
            long ans = 1;
            while (N > div) {
                ans *= N;
                N = N - 1;
            }

            System.out.println(ans);
        }
    }
}
