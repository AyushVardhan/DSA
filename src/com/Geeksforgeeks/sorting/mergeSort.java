package com.Geeksforgeeks.sorting;

import java.util.Scanner;

public class mergeSort {

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int arr[], int l, int m, int r)
    {
        // Your code here
        int n1 = m-l+1;
        int n2 = r-m;

        int L[] = new int[n1], R[] = new int[n2];
        for (int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }

        for (int i = 0; i < n2; i++){
            R[i] = arr[m+1+i];
        }

        int i=0,j=0,k=l;
        while (i<n1 && j<n2){
            if (L[i]<=R[j]){
                arr[k++] = L[i++];
            }else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1){
            arr[k++] = L[i++];
        }

        while (j < n2){
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            mergeSort(arr,0,arr.length-1);
            printArray(arr);
            T--;
        }
    }
}
