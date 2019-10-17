/*
Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
Examples:


Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array,
2 is missing and 3 occurs twice

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

______________________________________________________

Given an unsorted array of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Note: If you find multiple answers then print the Smallest number found. Also, expected solution is O(n) time and constant extra space.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print B, the repeating number followed by A which is missing in a single line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ A[i] ≤ N

Example:
Input:
2
2
2 2
3
1 3 3

Output:
2 1
3 2

Explanation:
Testcase 1: Repeating number is 2 and smallest positive missing number is 1.
Testcase 2: Repeating number is 3 and smallest positive missing number is 2.

______________________________________________________________________________

GFG Hint1:
1. Traverse the array. While traversing, use the absolute value of every element as an index and make the value at this index as negative to mark it visited. If something is already marked negative then this is the repeating element. To find missing, traverse the array again and look for a positive value.

GFG Hint2:
2. Make two equations:

Let x be the missing and y be the repeating element.

Get the the sum of all numbers using formula S = n(n+1)/2 – x + y

Get product of all numbers using formula P = 1*2*3*…*n * y / x

The above two steps give us two equations, we can solve the equations and get the values of x and y.
To overcome overflow of sum and product you sholud use long long

 */

package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingAndRepeating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] tmp = new int[n];
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < n; i++) {
                tmp[i] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                arr[arr[i] % n] = arr[arr[i] % n] + n;
                if (arr[arr[i] % n] > 2 * n) {
                    System.out.print(tmp[i] + " ");
                    break;
                }
            }

            int[] miss = new int[n + 1];
            for (int i = 0; i < n; i++) {
                miss[tmp[i]] = tmp[i];
            }

            for (int i = 1; i <= n; i++) {
                if (miss[i] == 0) {
                    System.out.print(i);
                    break;
                }
            }
            System.out.println();
        }
    }
}
