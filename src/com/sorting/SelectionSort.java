package com.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {411, 575, 686, 384, 887,183};
        int n = 6;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }

            int tmp;
            tmp = arr[min_idx];
            arr[min_idx]=arr[i];
            arr[i]=tmp;
        }

        for (int num :
                arr) {
            System.out.print(num + " ");
        }
    }
}
