package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FacingSun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 1, fst = arr[0];

            for (int i=1; i < n; i++){
                if (arr[i] > fst){
                    fst = arr[i];
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}