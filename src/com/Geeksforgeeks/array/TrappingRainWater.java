/*
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
| |
|_|
We can trap 2 units of water in the middle gap.


Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.
 */

package com.Geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] left = new int[n];
            int[] right = new int[n];

            int tmp = 0, res = 0;
            for (int i = 0; i < n; i++) {
                tmp = Math.max(tmp, arr[i]);
                left[i] = tmp;
            }

            tmp = 0;
            for (int i = n - 1; i >= 0; i--) {
                tmp = Math.max(tmp, arr[i]);
                right[i] = tmp;
            }

            for (int i = 0; i < n; i++) {
                if (left[i]==arr[i] || right[i]==arr[i]){
                    continue;
                }else {
                    tmp = Math.min(left[i],right[i]);
                    res += Math.abs(tmp - arr[i]);
                }
            }

            System.out.println(res);
        }
    }
}


/* hint:

As water can or cannot be stored at a particular index, we will have to compute the right and left arrays for maximum wall heights, that is ,
Compute the right array by taking maximum wall heights from right side, and left array by taking maximum wall heights from left side.

But how they help, in determinig the trapped water.

Simple, these array values will show , how much water can be saved due to height of wall on one side.

But, water is restricetd by both sides, so now what to do next...??
 */