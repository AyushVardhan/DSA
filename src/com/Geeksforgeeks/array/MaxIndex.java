/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Input:
The first line contains an integer T, depicting total number of test cases.  Then T test case follows. First line of each test case contains an integer N denoting the size of the array. Next line contains N space separated integeres denoting the elements of the array.

Output:
Print the maximum difference of the indexes i and j in a separtate line.

Constraints:
1 ≤ T ≤ 1000
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 1018

Example:
Input:
1
9
34 8 10 3 2 80 30 33 1

Output:
6

Explanation:
Testcase 1:  In the given array A[1] < A[7] satisfying the required condition(A[i] <= A[j]) thus giving the maximum difference of j - i which is 6(7-1).
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] small = new int[size];
            int[] great = new int[size];
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            small[0] = input[0];
            for (int i = 1; i < size; i++) {
                small[i] = Math.min(input[i],small[i-1]);
            }

            great[size-1] = input[size-1];
            for (int i = size - 2; i >= 0; i--) {
                great[i] = Math.max(input[i],great[i + 1]);
            }

            int max = 0, i = 0, j = 0;

            while (i < size && j < size) {
                if (small[i] <= great[j]) {
                    max = Math.max(max, j - i);
                    j = j + 1;
                } else {
                    i = i + 1;
                }
            }
            System.out.println(max);
        }
    }
}
