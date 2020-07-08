/*
You are given an array A, of N elements. You need to find minimum distance between given two integers x and y.

Distance: The distance (index-based) between two elements of the array.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting size array. Then in the next line are N space separated values of the array A. The last line of each test case contains two integers  x and y.

Output Format:
For each test case, print the required answer .

Your Task:
Your task is to complete the function minDist which returns  an integer denoting the minimum distance between two integers x and y in the array. If no such distance is possible then return -1.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A, x, y <= 105

Example:
Input:
2
2
1 2
1 2
7
86 39 90 67 84 66 62
42 12

Output:
1
-1

Explanation:
Testcase1: x = 1 and y = 2. minDistance between x and y is 1.
Testcase2: x = 42 and y = 12. We return -1 as the x and y don't exist in the array.
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumDistanceBwTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] input = br.readLine().trim().split(" ");
            String[] arg = br.readLine().trim().split(" ");

            int X = Integer.parseInt(arg[0]);
            int Y = Integer.parseInt(arg[1]);
            long a = -1, b = -1,diff = Integer.MAX_VALUE;

            for (int i = 0; i < input.length; i++) {
                long val = Integer.parseInt(input[i]);
                if (val == X) {
                    a = i;
                }
                if (val == Y) {
                    b = i;
                }
                if (a!=-1 && b!=-1){
                    long abs = Math.abs(a - b);
                    if (abs <diff){
                        diff = abs;
                    }
                }
            }

            if (a == -1 || b == -   1) {
                System.out.println(-1);
            }else {
                System.out.println(diff);
            }
        }
    }
}
