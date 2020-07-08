package com.Geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            int arr[][] = new int[n][n];

            int j = 0;
            for (int i=0; i < n*n ; i++){
                if (i>0 && i % n == 0){
                    j++;
                }
                arr[j][i%n]=ar[i];
            }

            for (j = 0; j < n; j++){
                for (int k = 0; k < n ; k++){
                    System.out.print(arr[k][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
