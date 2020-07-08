package com.Geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class checkSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int flag = 0;
            for (int i =0; i< size-1; i++){
                if (arr[i+1]<arr[i]){
                    flag = 1;
                    break;
                }
            }

            System.out.println(flag==1?0:1);
        }
    }
}
