/*

You a given a number N. You need to print the pattern for the given value of N.
for N=2 the pattern will be
2 2 1 1
2 1
for N=3 the pattern will be
3 3 3 2 2 2 1 1 1
3 3 2 2 1 1
3 2 1

Input Format:
The first line of input is the number of testcases T. The T test cases follow. The first line of each test case is an integer N.

Output Format:
For each test case, in a new line, print the required pattern in a singleline .
Note : Instead of printing new line print a "$" without quotes.

Your Task:
Since this is a function problem, you don't need to worry about the testcases. Your task is to complete the function printPat which takes one argument 'N' denoting the length of the pattern.

Constraints:
1 <= T <= 20
1 <= N <= 40

Example:
Input
2
2
3
Output
2 2 1 1 $2 1 $
3 3 3 2 2 2 1 1 1 $3 3 2 2 1 1 $3 2 1 $

*/
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintThePattern {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int mod = n;

            for (int i = n; i >= 1; i--) {
                int tmp = n;
                for (int j = 1; j <= n * i; j++) {
                    System.out.print(tmp + " ");
                    if (j % mod == 0){
                        tmp--;
                    }
                }
                System.out.print("$");
                mod--;
            }
        }
    }
}
