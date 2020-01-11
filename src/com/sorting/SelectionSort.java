package com.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {1,4,25,3,2};
        int n = 6;
        int count = 0;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }

            if (min_idx!=i){
                int tmp;
                tmp = arr[min_idx];
                arr[min_idx]=arr[i];
                arr[i]=tmp;
                count++;
            }
        }

        for (int num :
                arr) {
            System.out.print(num + " ");
        }
        System.out.println("In swaps: " + count);
    }
}
