package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){

            String[] s = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int flg = -1;

            for (int i=0; i<n; i++){
                if (arr[i]==k){
                    System.out.println(i+1);
                    flg = 0;
                    break;
                }
            }

            if (flg==-1){
                System.out.println(-1);
            }
        }
    }
}
