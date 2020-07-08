package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumOfOccurence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            String[] a1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(a1[0]);
            int x = Integer.parseInt(a1[1]);
            int count = 0;

            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int a : arr){
                if (a==x){
                    count++;
                }
            }

            System.out.println(count==0?-1:count);
        }
    }
}
