package com.programming.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            sort(arr, l, pi - 1);
            sort(arr, pi + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int j = l - 1;

        for (int i = l; i <= r-1; i++) {
            if (arr[i] < pivot) {
                j++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        int tmp = arr[j+1];
        arr[j+1] = arr[r];
        arr[r] = tmp;

        return j+1;
    }
}
