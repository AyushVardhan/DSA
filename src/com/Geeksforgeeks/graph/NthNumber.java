package com.Geeksforgeeks.graph;

public class NthNumber {
    static final int max = 100000;

    // function to convert num to base 6
    static int baseconversion(int arr[],
                              int num, int base)
    {
        int i = 0, rem, j;

        if (num == 0) {
            return 0;
        }

        while (num > 0) {

            rem = num % base;
            arr[i++] = rem;
            num /= base;
        }

        return i;
    }

    // Driver code
    public static void main (String[] args)
    {

        // initialize an array to 0
        int arr[] = new int[max];

        int n = 10;

        // function calling to convert
        // number n to base 6
        int size = baseconversion(arr, n - 1, 6);

        // if size is zero then return zero
        if (size == 0)
            System.out.print(size);

        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
