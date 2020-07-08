/*
For an integer n find number of trailing zeroes in n! .

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, it contains an integer 'N'.


Output:
In each seperate line output the answer to the problem.


Constraints:
1<=T<=100
1<=N<=1000


Example:
Input:
1
9

Output:
1
 */

package com.Geeksforgeeks.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZeros {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int count = (int) (Math.floor(num/5) + Math.floor(num/25) + Math.floor(num/125) + Math.floor(num/625));
            System.out.println(count);
        }
    }
}
