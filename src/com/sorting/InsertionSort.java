package com.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 9, 7};
        int n = 5;

        for (int i = 1; i < n; i++) {
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j = j - 1;
            }
            arr[j+1]=key;
        }

        for (int num :
                arr) {
            System.out.print(num + " ");
        }
    }
}
