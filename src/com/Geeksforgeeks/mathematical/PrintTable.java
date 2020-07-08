/*
Print the table of a given number N.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each testcase cotains one line of input denoting N.

Output:
For each testcase, print the table of N upto 10.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
1
9

Output:
9 18 27 36 45 54 63 72 81 90
 */
package com.Geeksforgeeks.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while(testCases-->0){
            int num = Integer.parseInt(br.readLine());
            for(int i = 1 ; i <= 10 ; i++){
                System.out.print(num*i+" ");
            }
            System.out.println();
        }
    }
}
