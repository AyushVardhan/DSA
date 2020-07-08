package com.Geeksforgeeks.binarysearchtree;

import java.util.Scanner;

public class ArrayToBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n =in.nextInt();
            int arr[] = new int[n];
            for (int i = 0 ; i < n ; i++)
                arr[i] = in.nextInt();

            preOrder(arr, 0, arr.length - 1);
        }
    }

    private static void preOrder(int[] arr, int s, int e) {
        if (s > e)
            return;

        int mid = (s + e) / 2;
        System.out.print(arr[mid] + " ");

        preOrder(arr, s, mid - 1);
        preOrder(arr, mid + 1, e);
    }
}
