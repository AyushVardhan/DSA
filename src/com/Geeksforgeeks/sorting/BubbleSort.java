package com.Geeksforgeeks.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int ar[] = {4, 1, 3, 9, 7};
        int n = 5;
        int tmp;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (ar[j] > ar[j+1]) {
                    tmp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = tmp;
                }
            }
        }

        for (int num :
                ar) {
            System.out.print(num + " ");
        }
    }
}
