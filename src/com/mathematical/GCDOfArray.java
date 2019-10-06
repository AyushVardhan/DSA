/*
Given an array of N positive integers. Your task is to find the GCD of all numbers of the array.

Input:
First line of input contains number of test cases T. First line of test case contains a positive integer N, size of the array. Next line contains the array elements.

Output:
For each testcase, print the GCD of array elements.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Arr[i] <= 106

Example:
Input:
1
2
5 10

Output:
5

Explanation:
Testcase 1: For array elements 5,10 GCD will be 5.
 */

package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            long ans = 0;
            if(size==1){
                ans = Long.parseLong(arr[0]);
            }else {
                for (int i = 0 ; i < size-1 ; i++){
                    if(i == 0){
                        ans = HCF(Long.parseLong(arr[i]),Long.parseLong(arr[i+1]));
                    }else {
                        ans = HCF(ans,Long.parseLong(arr[i+1]));
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static long HCF(long N, long M) {
        long a, b;
        if (N >= M) {
            a = N;
            b = M;
        } else {
            a = M;
            b = N;
        }

        long r;
        while (a > b) {
            r = a % b;
            if(r==0){
                break;
            }

            a = b;
            b = r;
        }
        return b;
    }
}
