package com.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortTheHalf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine().trim());
        while (test-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = (int) Math.ceil(n / 2);
            merge(ar, n);
            printArray(ar);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void merge(int ar[], int n) {
        int half = -1;
        for (int i =0; i<n-1 ; i++){
            if (ar[i] > ar[i+1]){
                half = i+1;
                break;
            }
        }

        if (half == -1){
            return;
        }

        int tmp[] = new int[n];

        int i = 0;
        int j = half;
        int k = 0;

        while (i<half && j<n){
            if (ar[i]<=ar[j]){
                tmp[k++] = ar[i++];
            }else {
                tmp[k++] = ar[j++];
            }
        }
        
        while (i<half){
            tmp[k++]=ar[i++];
        }
        
        while (j<n){
            tmp[k++]=ar[j++];
        }

        for (int l=0; l< n ; l++){
            ar[l]=tmp[l];
        }
    }
}
