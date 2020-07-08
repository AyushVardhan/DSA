/*
Given the first 2 terms A and B of an Arithmetic Series, tell the Nth term of the series.

Input:
The first line of input contains an integer, the number of test cases T. T testcases follow. Each testcase in its first line should contain two positive integer A and B(First 2 terms of AP). In the second line of every testcase it contains of an integer N.

Output:
For each testcase, in a new line, print the Nth term of the Arithmetic Progression.

Constraints:
1 <= T <= 100
-103 <= A <= 103
-103 <= B <= 103
1 <= N <= 104

Example:
Input:
2
2 3
4
1 2
10

Output:
5
10
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(br.readLine());
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int diff = B - A;
            System.out.println(A + (N-1)*diff);
        }
    }
}
