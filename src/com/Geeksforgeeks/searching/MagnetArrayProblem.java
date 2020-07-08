package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagnetArrayProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j<n ; j++){
                double l = arr[j-1];
                double h = arr[j];
                while (true){
                    double mid = (l + h)/2;
                    double k =0;
                    for (int i = 0; i < n; i++)
                        k += 1/(mid-arr[i]);
                    if (Math.abs(k) < 0.0000000000001) {
                        System.out.printf("%.2f",mid);
                        break;
                    }
                    else if (k > 0) {l = mid;}
                    else {h = mid;}
                }
            }
        }
    }
}
