package com.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Median {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr);
            if (n%2==0){
                System.out.println((int)Math.floor((arr[n/2]+arr[(n/2)-1])/2));
            }else {
                System.out.println((int)Math.floor(arr[n/2]));
            }
        }
    }
}
