/*
You are given an array A of size N. You need to find all pairs in the array that sum to a number K. If no such pair exists then output will be -1. The elements of the array are distinct and are in sorted order.
Note: (a,b) and (b,a) are considered same. Also, an element cannot pair with itself, i.e., (a,a) is invalid.

Input:
The first line of input is T denoting the number of testcase. T testcases follow. Each testcase contains three lines of input. The first line is the size of array N. The second line contains N elements separated by spaces. The third line contains the sum K.

Output:
For each testcase, print all the pairs such that there sum is equal to K.

Constraints:
1 <= T <= 100
0 <= Ai <=107
2 <= N <= 107
0 <= K <= 107

Examples:
Input:
2
7
1 2 3 4 5 6 7
98
7
1 2 3 4 5 6 7
8
Output:
-1
1 7 8
2 6 8
3 5 8

Explanation:
Testcase1: We cannot find any pair that sums to 98
Testcase2: We find 3 such pairs that sum to 8 (1,7) (2,6) (3,5)
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairWithSumInSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine());

            int i = 0, j = size - 1;
            boolean flag = false;

            while (i < j) {
                int tmp = arr[i] + arr[j];
                if (tmp == k) {
                    System.out.println(arr[i] + " " + arr[j] + " " + k);
                    i = i + 1;
                    j = j - 1;
                    flag = true;
                } else if (tmp > k) {
                    j = j - 1;
                } else {
                    i = i + 1;
                }
            }

            if (!flag){
                System.out.println(-1);
            }
        }
    }
}


/* Brute Force:

            int i = 0, j = size - 1;

            if (arr[i] + arr[j] < k) {
                System.out.println(-1);
            } else {
                for (i = 0; i <= j; i++){
                    for (int m = i+1; m <= j; m++){
                        int tmp = arr[i]+arr[m];
                        if (tmp > k){
                            break;
                        }
                        if (tmp < k){
                            continue;
                        }
                        System.out.println(arr[i] + " " + arr[m] + " " + k);
                    }
                }
            }

 */