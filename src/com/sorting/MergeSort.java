package com.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        int k = 0;
        for (int i = 0; i < n1; i++) {
            L[k++] = arr[l + i];
        }

        k = 0;
        for (int i = 0; i < n2; i++) {
            R[k++] = arr[m + 1 + i];
        }

        k = l;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
