/*
Given two sorted arrays A and B. The task is to complete the function max_path_sum that takes 4 argument, the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote the size of array A and B respectively. The function returns the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays .

Note: You can switch from one array to another array only at common elements.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T cases follow.
Each test case contains 3 lines. The first line contains two space separated integers l1 and l2 denoting the length of the two sorted array A and B. In the second line is the space separated values of array A and in the third line are space separated values of array B.

Output:
For each test case the output is the max sum obtained in such fashion .

Constraints:
1 <= T <= 100
1 <= N, M <= 103
1 <= A[], B[] <= 104

Example:
2
5 4
2 3 7 10 12
1 5 7 8
3 3
1 2 4
1 2 7

Output
35
10

Explanation:
Testcase 1: For first test case the path will be 1+5+7+10+12 = 35.
Testcase 2: For second test case the path will be 1+2 +7=10.

 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumpathInTwoArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] sizes = br.readLine().split(" ");
            int l1 = Integer.parseInt(sizes[0]);
            int l2 = Integer.parseInt(sizes[1]);

            int[] ar1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ar2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int i = 0, j = 0, sum1 = 0, sum2 = 0, sum = 0, m = ar1.length, n = ar2.length;
            while (i < m && j < n) {
                if (ar1[i] < ar2[j]) {
                    sum1 += ar1[i++];
                } else if (ar1[i] > ar2[j]) {
                    sum2 += ar2[j++];
                } else {
                    sum += Math.max(sum1, sum2);

                    sum1 = 0;
                    sum2 = 0;

                    while (i < m && j < n && ar1[i] == ar2[j]) {
                        sum += ar1[i++];
                        j++;
                    }
                }
            }

            while (i < ar1.length) {
                sum1 += ar1[i++];
            }

            while (j < ar2.length) {
                sum2 += ar2[j++];
            }

            sum += Math.max(sum1, sum2);
            System.out.println(sum);
        }
    }
}
