package com.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryArraySorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int zero = 0, one = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i]<1){
                    zero++;
                }else{
                    one++;
                }
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < zero; i++) {
                if (i==zero-1 && one==0){
                    sb.append(0);
                }else {
                    sb.append(0+" ");
                }
            }

            for (int i = 0; i < one; i++) {
                if (i==one-1){
                    sb.append(1);
                }else {
                    sb.append(1+" ");
                }
            }

            System.out.println(sb);
        }
    }
}
