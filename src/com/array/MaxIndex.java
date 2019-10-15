package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int size = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int flag = 0;

            for (int j = size-1; j >= size/2 ; j--){
                for (int i = 0; i< size/2;i++){
                    if (arr[i]<=arr[j]){
                        System.out.println(j-i);
                        flag = 1;
                        break;
                    }
                }

                if (flag==1){
                    break;
                }
            }
        }
    }
}
