package com.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SmallestPositive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[1000000];

        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();


            int max = 0;
            for (int i =0; i< n ; i++){
                if (ar[i]>max){
                    max = ar[i];
                }
            }

            for (int i = 0; i < n; i++){
                if (ar[i]>0){
                    arr[ar[i]] = 1;
                }
            }

            for (int i = 1; i <= max ; i++){
                if (i==max && arr[i]!=0){
                    System.out.println(i+1);
                    break;
                }
                if (arr[i]==0){
                    System.out.println(i);
                    break;
                }
            }

            Arrays.fill(arr,0);
        }
    }
}
