/*
Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles.

Input:
The first line of the input contains T denoting the number of testcases. First line of test case is the length of array N and second line of test case are its elements.

Output:
Number of possible triangles are displayed to the user.

Constraints:
1 <= T <= 200
3 <= N <= 107
1 <= arr[i] <= 103

Example:
Input:
2
3
3 5 4
5
6 4 9 7 8

Output:
1
10
 */

package com.Geeksforgeeks.array;

import java.util.Arrays;
import java.util.Scanner;


class CountTriangles
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(Num_of_Triangles(arr, n));
        }
    }

    public static long Num_of_Triangles(int arr[], int n)
    {
        Arrays.sort(arr);

        long count = 0L;
        for(int i = 0; i < n-2; i++)
        {
            int k = i+2;

            for (int j = i+1; j < n; ++j)
            {

                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                count += k - j - 1;
            }
        }
        return count;
    }
}