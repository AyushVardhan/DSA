/*
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6
 */

package com.array;

import java.util.Scanner;

public class FindDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();

        while (testCase-- > 0) {

            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int flag = 0;

            for (int i = 0; i < n; i++) {
                arr[arr[i] % n] = arr[arr[i] % n] + n;
                if (arr[arr[i] % n] >= 2 * n) {
                    flag = 1;
                    System.out.print((arr[i] % n) + " ");
                }
            }

            if (flag == 0) {
                System.out.print(-1);
            }

            System.out.println();
        }
    }
}
