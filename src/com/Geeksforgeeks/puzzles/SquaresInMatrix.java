/*
Given a MxN matrix, count the number of squares in the matrix.

Input:

The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two space seperated integers M and N, denoting the size of the Matrix.
Output:

For each test output a single integer denoting the total number of squares.
Constraints:

1<=T<=102
1<=M,N<=10^4

Example:

Input:

2
2 2
4 3

Output:

5
20
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquaresInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            long sum = 0;

            for (int i = 0; i < Math.min(m, n); i++) {
                sum = sum + ((m - i) * (n - i));
            }

            System.out.println(sum);
        }
    }
}
