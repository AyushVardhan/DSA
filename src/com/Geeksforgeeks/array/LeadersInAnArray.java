/*
Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print all the leaders.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Ai <= 107

Example:
Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3

Explanation:
Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            String[] ipt = br.readLine().split(" ");
            for (int i = 0; i < size ; i++){
                arr[i] = Integer.parseInt(ipt[i]);
            }

            List<Integer> out = new ArrayList<>();

            int max = arr[size-1];
            out.add(max);

            for (int i = size-2; i >= 0 ; i--){
                if(arr[i]>=max){
                    max = arr[i];
                    out.add(max);
                }
            }

            StringBuffer str = new StringBuffer();

            for (int i = out.size()-1 ; i>=0 ;i--){
                str.append(out.get(i)+" ");
            }
            System.out.println(str);
        }
    }
}
