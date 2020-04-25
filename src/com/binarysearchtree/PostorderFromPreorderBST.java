package com.binarysearchtree;

import java.util.Scanner;

public class PostorderFromPreorderBST {
    static int idx = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            idx = 0;
            int n = in.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            printPostorder(arr, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println();
        }
    }

    private static void printPostorder(int[] arr, int n, int minValue, int maxValue) {
        if (idx == n)
            return;

        if (arr[idx] < minValue || arr[idx] > maxValue)
            return;

        int val = arr[idx];
        idx = idx + 1;

        printPostorder(arr, n, minValue, val);
        printPostorder(arr, n, val, maxValue);
        System.out.print(val + " ");
    }
}
