package com.programming.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int n) {
        for (int i = 0; i < n; i++) {
            int minidx = i;
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] < arr[minidx])
                    minidx = j;
            }

            int tmp = arr[minidx];
            arr[minidx] = arr[i];
            arr[i] = tmp;
        }
    }
}
