package com.Geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortingZeroOneTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int low = 0, high = size-1, mid = 0;
            while (mid<=high){
                if (arr[mid]==0){
                    int tmp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = tmp;
                    mid++;
                    low++;
                }else if (arr[mid]==2){
                    int tmp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = tmp;
                    high--;
                }else {
                    mid++;
                }
            }
            for (int i=0; i< size; i++){
                System.out.print(arr[i]+" ");
            }

            System.out.println();
        }
    }
}
