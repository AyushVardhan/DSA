/*
Given an integer array A of size N, find sum of elements in it.

Input:
First line contains an integer denoting the test cases 'T'. T testcases follow. Each testcase contains two lines of input. First line contains N the size of the array A. The second line contains the elements of the array.

Output:
For each testcase, print the sum of all elements of the array in separate line.

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Ai <= 100

Example:
Input:
2
3
3 2 1
4
1 2 3 4
Output:
6
10
 */

package com.Geeksforgeeks.array;

import java.util.Scanner;

public class SumOfElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();

        while (testCase-- > 0) {
            int size = in.nextInt();
            long sum = 0;
            while (size-- > 0) {
                long num = in.nextLong();
                sum += num;
            }
            System.out.println(sum);
        }
    }
}