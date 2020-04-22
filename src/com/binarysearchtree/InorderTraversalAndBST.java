package com.binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InorderTraversalAndBST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0) {
            int len = Integer.parseInt(br.readLine());
            int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int flag = 1;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i + 1] <= arr[i]) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}
