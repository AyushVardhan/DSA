/*
You are given an array A of size N. You need to print elements of A in alternate order.

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each test case contains two lines of input. The first line contains N and the second line contains the elements of the array.

Output Format:
For each testcase, print the alternate elements of the array(starting from index 0).

Your Task:
Since this is a function problem, you just need to complete the provided function void print(int ar[],int n)

Constraints:
1 <= T <= 200
1 <= N <= 105
1 <= Ai <= 105

Example:
Input:
2
4
1 2 3 4
5
1 2 3 4 5
Output:
1 3
1 3 5

Explanation:
Testcase1: print 1, then 3.
Testcase2: print 1, then 3, then 5.
 */

package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatePrinting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int size = Integer.parseInt(br.readLine());
            int arr[] = new int[size];
            String[] input = br.readLine().split(" ");
            for (int i = 0 ; i< input.length ; i++){
                arr[i]=Integer.parseInt(input[i]);
            }
            printAlternate(arr,size);
        }
    }

    private static void printAlternate(int[] arr, int n) {
        for (int i = 0 ; i<n ; i += 2){
            System.out.print(arr[i]+" ");
        }
    }
}
