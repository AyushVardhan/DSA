/*
Given an array A of size N, print second largest element from an array.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains an integer N denoting the size of the array. The second line contains the N space seperated intgers of the array

Output:
For each testcase, in a new line, print the second largest element.

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 500
1 ≤ Ai ≤ 1200

Example:
Input
2
5
89 24 75 11 23
6
56 42 21 23 6
 */

package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int arr[] = new int[size];
            String[] input = br.readLine().split(" ");
            for (int i = 0 ; i < input.length ; i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(arr);
            System.out.println(arr[size-2]);
        }
    }
}