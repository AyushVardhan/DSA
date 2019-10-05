/*
Given the first 2 terms A and B of a Geometric Series. The task is to find the Nth term of the series.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case in its first line contains two integer A and B (First 2 terms of GP). In the second line of every test case it contains of an integer N.

Output:
In each seperate line print the Nth term of the Geometric Progression. Print the floor ( floor(2.3)=2 ) of the answer. Both the terms A and B forms a valid GP.

Constraints:
1 <= T <= 30
-100 <= A <= 100
-100 <= B <= 100
1 <= N <= 5

Example:
Input:
2
2 3
1
1 2
2

Output:
2
2

Explanation:
Testcase 2: The second term of series whose common ratio is 2 will be 2.
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesGP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-->0){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(br.readLine());
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            double D = (double) B/(double) A;
            int ans = (int) Math.floor((double)A*Math.pow(D,N-1));
            System.out.println(ans);
        }
    }
}
