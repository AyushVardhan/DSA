package com.divideConquer;


import java.util.*;
import java.io.*;
import java.lang.*;

public class InversionsInArray {
    static long mergeSort(long arr[], long n) {
        long temp[] = new long[(int) n];
        return _mergeSort(arr, temp, 0, n - 1);
    }

    static long _mergeSort(long arr[], long temp[],
                           long left, long right) {
        long mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;

            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }


    static long merge(long arr[], long temp[], long left,
                      long mid, long right) {
        long i, j, k;
        long inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                temp[(int) k++] = arr[(int) j++];

                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1)
            temp[(int) k++] = arr[(int) i++];


        while (j <= right)
            temp[(int) k++] = arr[(int) j++];

        for (i = left; i <= right; i++)
            arr[(int) i] = temp[(int) i];

        return inv_count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(mergeSort(arr, n));

        }
    }
}