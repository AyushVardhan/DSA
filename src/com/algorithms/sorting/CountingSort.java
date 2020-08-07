package com.algorithms.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,1,2,7,5,2};
        System.out.println(Arrays.toString(getSortedArr(arr)));
    }

    private static int[] getSortedArr(int[] arr) {
        int n = arr.length;
        int output[] = new int[n];

        int count[] = new int[10];
        for (int i=0; i<10; ++i)
            count[i] = 0;

        for (int i=0; i<n; ++i)
            ++count[arr[i]];

        for (int i=1; i<=9; ++i)
            count[i] += count[i-1];

        for (int i = n-1; i>=0; i--)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i<n; ++i)
            arr[i] = output[i];

        return arr;
    }
}
