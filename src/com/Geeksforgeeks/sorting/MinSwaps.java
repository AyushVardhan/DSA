package com.Geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine().trim());

        while (test-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(minSwaps(arr,size));
        }
    }

    public static int minSwaps(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N-1; i++) {
            int min_idx = i;
            for (int j=i+1;j<A.length;j++){
                if (A[j]<A[min_idx]){
                    min_idx=j;
                }
            }

            if (min_idx!=i){
                int tmp;
                tmp = A[min_idx];
                A[min_idx]=A[i];
                A[i]=tmp;
                count++;
            }
        }

       return count;
    }
}