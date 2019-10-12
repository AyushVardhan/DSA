/*
Given an sorted array A of size N. Find number of elements which are less than or equal to given element X.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each testcase contains 3 lines of input. The first line contains an integer N denoting the size of the array. Then the next line contains N space separated integers forming the array. The third line contains an element X.

Output:
For each testcase, in a new line, print the number of elements which are less than or equal to given element.

Constraints:
1 <= T <= 105
1 <= N <= 105
1 <= Ai <= 105
0 <= X <= 105

Example:
Input:
2
6
1 2 4 5 8 10
9
7
1 2 2 2 5 7 9
2
Output:
5
4
 */

package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOfSmaller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(br.readLine()),count = 0;
            for (int i = 0 ; i < size;i++){
                if (Integer.parseInt(input[i])<=num){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
